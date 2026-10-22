
import java.util.concurrent.locks.ReentrantLock

class WorkerPool {

    companion object {
        val MAX_SIZE = 10
    }

    private val workerCapacity: Int
    private var running = true
    private var started = false

    private val lock = ReentrantLock()
    private val notEmpty = lock.newCondition()
    private val notFull = lock.newCondition()
    private val workerQ = mutableListOf<String>()
    private val workers = mutableListOf<Thread>()

    constructor(workerCapacity: Int) {
        require(workerCapacity > 0)
        this.workerCapacity = workerCapacity
    }

    constructor() {
        this.workerCapacity = MAX_SIZE
    }

    fun submit(job: String) {
        lock.lock()
        try {
            while (running && workerQ.size == workerCapacity) {
                notFull.await()
            }
            if (!running) {
                throw IllegalStateException("pool is shutdown")
            }
            workerQ.add(job)
            notEmpty.signal()
        } finally {
            lock.unlock()
        }
    }

    fun execute(job: String) {
        println("${Thread.currentThread().name} processing $job")
    }

    fun worker() {
        var job: String
        while (true) {
            lock.lock()
            try {
                while (workerQ.isEmpty() && running) {
                    notEmpty.await()
                }
                if (!running && workerQ.size == 0) {
                    return
                }
                job = workerQ.removeAt(0)
                notFull.signal()
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                return
            } finally {
                lock.unlock()
            }
            try {
                execute(job)
            } catch (e: RuntimeException) {
                System.err.println("${Thread.currentThread().name} failed on $job: $e")
            }
        }
    }

    fun shutdown() {
        var snapshot = mutableListOf<Thread>()
        lock.lock()
        try {
            running = false
            notEmpty.signalAll()
            notFull.signalAll()
            snapshot = ArrayList<Thread>(workers)
        } finally {
            lock.unlock()
        }

        for (th in snapshot) {
            th.join()
        }
    }

    fun start(numOfWorkers: Int) {
        if (numOfWorkers <= 0) {
            throw IllegalArgumentException("numOfWorks must be greater than 0")
        }
        lock.lock()
        try {
            if (started) {
                return
            }
            started = true
            for (i in 1..numOfWorkers) {
                val worker = Thread(this::worker, "worker-$i")
                workers.add(worker)
                worker.start()
            }
        } finally {
            lock.unlock()
        }
    }

}

fun main() {
    val pool = WorkerPool(2)
    println("starting pool with capacity 2 and 1 worker")

    pool.start(1)
    pool.start(1) // second start is a no-op

    for (i in 1..5) {
        // queue capacity is 2, so submit blocks until the worker frees a slot
        pool.submit("job-$i")
    }

    println("all jobs submitted, shutting down (drains remaining jobs)")
    pool.shutdown()
    println("shutdown complete")

    try {
        pool.submit("too-late")
    } catch (e: IllegalStateException) {
        println("submit after shutdown rejected: ${e.message}")
    }
}

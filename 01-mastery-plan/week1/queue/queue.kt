import java.util.concurrent.locks.ReentrantLock

class BlockingQueue {

    private val lock = ReentrantLock()
    private val notEmpty = lock.newCondition()
    private val buffer = mutableListOf<Int>()

    fun put(item: Int) {
        lock.lock()
        try {
            buffer.add(item)
            notEmpty.signal()
        } finally {
            lock.unlock()
        }
    }

    fun take(): Int {
        lock.lock()
        try {
            while (buffer.size == 0) {
                notEmpty.await()
            }
            return buffer.removeAt(0)
        } finally {
            lock.unlock()
        }
    }
}

class BoundedBuffer {
    val capacity: Int

    private val lock = ReentrantLock()
    private val notEmpty = lock.newCondition()
    private val notFull = lock.newCondition()
    private val buffer = mutableListOf<Int>()

    companion object {
        const val DEFAULT_CAPACITY = 100
    }

    constructor(capacity: Int) {
        require(capacity > 0) {
            "capacity must be > 0"
        }
        this.capacity = capacity
    }

    constructor() {
        this(DEFAULT_CAPACITY)
    }

    fun put(item: Int) {
        lock.lock()
        try {
            while (buffer.size == capacity) {
                notFull.await()
            }
            buffer.add(item)
            notEmpty.signal()
        } finally {
            lock.unlock()
        }
    }

    fun take(): Int {
        lock.lock()
        try {
            while (buffer.size == 0) {
                notEmpty.await()
            }
            val item = buffer.removeAt(0)
            notFull.signal()
            return item
        } finally {
            lock.unlock()
        }
    }
}

fun mainBuffer() {
    val buffer = BoundedBuffer(3)
    val consumer = Thread({
        try {
            for (i in 1..6) {
                val item = buffer.take()
                println("consumer: took $item")
                Thread.sleep(300)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }, "consumer")

    val producer = Thread({
        try {
            for (i in 1..6) {
                println("producer: putting $i")
                buffer.put(i)
                println("producer: put $i")
            }
            println("producer: done")
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }, "producer")

    consumer.start()
    producer.start()

    producer.join()
    consumer.join()

}

fun mainQueue() {
    val buffer = BlockingQueue()
    val consumer = Thread({
        try {
            for (i in 1..6) {
                val item = buffer.take()
                println("consumer: took $item")
                Thread.sleep(300)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }, "consumer")

    val producer = Thread({
        try {
            for (i in 1..6) {
                println("producer: putting $i")
                buffer.put(i)
                println("producer: put $i")
            }
            println("producer: done")
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }, "producer")

    consumer.start()
    producer.start()

    producer.join()
    consumer.join()
}

fun main() {
    mainBuffer()
    mainQueue()
}

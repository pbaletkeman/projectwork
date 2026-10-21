import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WorkerPool {

    private static final int MAX_SIZE = 10;
    private int workerCapacity;
    private boolean running;
    private boolean started;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private final List<String> workerQ = new ArrayList<>();
    private final List<Thread> workers = new ArrayList<>();

    public WorkerPool(int workerCapacity) {
        if (workerCapacity <= 0){
            throw new IllegalArgumentException("pool size must be > 0");
        }
        this.workerCapacity = workerCapacity;
        this.running = true;
    }

    public WorkerPool(){
        this.workerCapacity = MAX_SIZE;
        this.running = true;
    }

    public void submit(String job) throws InterruptedException {
        if (job == null) {
            throw new NullPointerException("job must not be null");
        }
        lock.lock();
        try {
            while (running && workerQ.size() == workerCapacity) {
                notFull.await();
            }
            if (!running) {
                throw new IllegalStateException("pool is shutdown");
            }
            workerQ.add(job);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void execute(String job) {
        System.out.println(Thread.currentThread().getName() + " processing " + job);
    }

    public void worker() {
        String job;
        while (true) {
            lock.lock();
            try {
                while (workerQ.size() == 0 && running) {
                    notEmpty.await();
                }
                if (!running && workerQ.size() == 0) {
                    return;
                }
                job = workerQ.remove(0);
                notFull.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                lock.unlock();
            }
            try {
                execute(job);
            } catch (RuntimeException e) {
                System.err.println(Thread.currentThread().getName() + " failed on " + job + ": " + e);
            }
        }
    }

    public void shutdown() throws InterruptedException {
        List<Thread> snapshot;
        lock.lock();
        try {
            running = false;
            notEmpty.signalAll();
            notFull.signalAll();
            snapshot = new ArrayList<>(workers);
        } finally {
            lock.unlock();
        }

        for (Thread w: snapshot) {
            w.join();
        }
    }

    public void start(int numWorkers) {
        if (numWorkers <= 0) {
            throw new IllegalArgumentException ("numWorkers must be greater than 0");
        }
        lock.lock();
        try {
            if (started) {
                return;
            }
            started = true;
            for (int i = 1; i <= numWorkers; i++) {
                Thread worker = new Thread(this::worker, "worker-" + i);
                workers.add(worker);
                worker.start();
            }
        } finally {
            lock.unlock();
        }
    }
}

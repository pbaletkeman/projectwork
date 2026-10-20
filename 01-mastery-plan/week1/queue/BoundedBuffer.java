import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {

    private static final int DEFAULT_CAPACITY = 100;

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private List<Integer> buffer = new ArrayList<>();
    private int capacity;

    public BoundedBuffer() {
        this(DEFAULT_CAPACITY);
    }

    public BoundedBuffer(int size) {
        if (size > 0) {
            this.capacity = size;
        } else {
            throw new IllegalArgumentException("capacity must be > 0");
        }
    }

    public void put(Integer item) throws InterruptedException  {
        lock.lock();
        try {
            while (buffer.size() == capacity) {
                notFull.await();
            }
            buffer.add(item);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Integer take() throws InterruptedException {
        Integer item;
        lock.lock();
        try {
            while (buffer.size() == 0) {
                notEmpty.await();
            }
            item = buffer.remove(0);
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return item;
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer buffer = new BoundedBuffer(3);

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    int item = buffer.take();
                    System.out.println("consumer: took " + item);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "consumer");

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    System.out.println("producer: putting " + i);
                    buffer.put(i);
                    System.out.println("producer: put " + i);
                }
                System.out.println("producer: done");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "producer");

        consumer.start();
        producer.start();

        producer.join();
        consumer.join();
    }
}

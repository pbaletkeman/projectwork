    import java.util.ArrayList;
    import java.util.List;
    import java.util.concurrent.locks.Condition;
    import java.util.concurrent.locks.ReentrantLock;

    public class BlockingQueue {

        private ReentrantLock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();
        private List<Integer> buffer = new ArrayList<>();

        public void put(Integer item) {
            lock.lock();
            try {
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
            } finally {
                lock.unlock();
            }
            return item;
        }

        public static void main(String[] args) throws InterruptedException {
            BlockingQueue queue = new BlockingQueue();

            Thread consumer = new Thread(() -> {
                try {
                    for (int i = 1; i <= 6; i++) {
                        int item = queue.take();
                        System.out.println("consumer: took " + item);
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "consumer");

            Thread producer = new Thread(() -> {
                for (int i = 1; i <= 6; i++) {
                    System.out.println("producer: putting " + i);
                    queue.put(i);
                }
                System.out.println("producer: done");
            }, "producer");

            consumer.start();
            producer.start();

            producer.join();
            consumer.join();
        }
    }

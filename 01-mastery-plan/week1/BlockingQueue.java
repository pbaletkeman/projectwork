package week1;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;


public class BlockingQueue {

    private List<String> queue;
    private final static int MAX_SIZE = 50;
    private final ReentrantLock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    // public List<String> getQueue() {
    //     return queue;
    // }

    // public void setQueue(List<String> queue) {
    //     this.queue = queue;
    // }

    public BlockingQueue(){
        queue = new ArrayList<>();
    }

    public static void main(String[] args){
        System.out.println("pete");
    }

    public void put(String item){
        lock.lock();
        try {
            while (queue.size() >= MAX_SIZE){
                notFull.await();
            }
            queue.add(item);
            notEmpty.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get(){
        String item = null;
        lock.lock();
        try {
            while (queue.size() == 0){
                notEmpty.await();
            }
            item = queue.remove(0);
            notFull.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }

}

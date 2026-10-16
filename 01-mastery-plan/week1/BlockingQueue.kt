import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


class BlockingQueue {
    var queue: MutableList<String>  =  mutableListOf<String>()
    // set(value) {
    //     field = value
    // }

    val MAX_SIZE = 50
    val lock: ReentrantLock = ReentrantLock()
    val notFull = lock.newCondition()
    val notEmpty = lock.newCondition()


    fun put(item: String){
        lock.lock()
        try {
            while (queue.size >= MAX_SIZE) {
                notEmpty.await()
            }
            queue.add(item)
            notFull.signal()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            lock.unlock()
        }
    }

    fun get(): String? {
        var item: String? = null
        lock.lock()
        try{
            while (queue.size == 0){
                notFull.await()
            }
            item = queue.removeAt(0)
            notEmpty.signal()
        } catch (e: Exception){
            e.printStackTrace()
        } finally {
            lock.unlock()
        }
        return item
    }
}

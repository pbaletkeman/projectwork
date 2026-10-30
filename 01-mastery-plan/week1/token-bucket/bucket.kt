import java.util.concurrent.locks.ReentrantLock

enum class Status {
    SUCCESS,
    RATE_LIMIT_EXCEEDED
}

class RateBucket {

    private val capacity: Float
    private val refillRate: Float
    private var lastRefillTime: Long
    private val lock: ReentrantLock

    var currentTokens: Float

    constructor (capacity: Float, refillRate: Float) {
        require(capacity > 0) {
            "capacity must be > 0"
        }
        require(refillRate > 0) {
            "refill rate must be > 0"
        }
        this.capacity = capacity
        this.refillRate = refillRate
        this.lastRefillTime = System.nanoTime()
        this.lock = ReentrantLock()
        this.currentTokens = capacity
    }

    fun request(tokenAmount: Float): Status {
        require(tokenAmount> 0) {"token amount must be > 0"}
        lock.lock()
        try {
            val currentTime = System.nanoTime()

            val elapsedNanos = currentTime - lastRefillTime
            val tokensToAdd = elapsedNanos * refillRate / 1_000_000_000f

            currentTokens = Math.min(capacity, currentTokens + tokensToAdd)
            lastRefillTime = currentTime

            if (tokenAmount > currentTokens) {
                return Status.RATE_LIMIT_EXCEEDED
            }

            currentTokens -= tokenAmount
        } finally {
            lock.unlock()
        }
        return Status.SUCCESS
    }
}

/**
 * Segment 5 coding problem: N requests/sec, burst of size B, reject excess.
 */
fun main() {
    val nPerSecond = 5
    val burstCapacity = 10
    val limiter = RateBucket(burstCapacity.toFloat(), nPerSecond.toFloat())

    // Burst: 12 instant requests -> at most B succeed, excess rejected
    val burstSuccess = (1..12).count { limiter.request(1f) == Status.SUCCESS }
    println("burst: $burstSuccess allowed, ${12 - burstSuccess} rejected (B=$burstCapacity)")
    check(burstSuccess == burstCapacity) { "expected $burstCapacity successes, got $burstSuccess" }

    // Sustain: after 1 second the bucket refills N tokens
    Thread.sleep(1000)
    val refillSuccess = (1..nPerSecond).count { limiter.request(1f) == Status.SUCCESS }
    println("after 1s: $refillSuccess/$nPerSecond requests allowed (N=$nPerSecond/s)")
    check(refillSuccess == nPerSecond) { "expected $nPerSecond refilled requests, got $refillSuccess" }

    // Bucket is empty again -> excess rejected
    check(limiter.request(1f) == Status.RATE_LIMIT_EXCEEDED) { "expected rejection after refill consumed" }
    println("segment 5 demo passed")
}

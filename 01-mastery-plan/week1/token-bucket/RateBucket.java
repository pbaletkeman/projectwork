import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Status
 */
enum Status {
    SUCCESS,
    RATE_LIMIT_EXCEEDED
}

public class RateBucket {

    final private int capacity;
    final private int refillRate;
    private float currentTokens;
    private long lastRefillTime;
    private final ReentrantLock lock;

    public RateBucket(int capacity, int refillRate) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        if (refillRate <= 0) {
            throw new IllegalArgumentException("refill rate must be > 0");
        }
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.lastRefillTime = System.nanoTime();
        this.lock = new ReentrantLock();
        this.currentTokens = capacity;
    }

    public Status request(float tokenAmount) {
        if (tokenAmount <= 0) {
            throw new IllegalArgumentException("token amount must be > 0");
        }
        lock.lock();
        try {
            long currentTime = System.nanoTime();

            long elapsedNanos = (currentTime - lastRefillTime);

            float tokensToAdd = elapsedNanos * refillRate / 1_000_000_000f;
            currentTokens = Math.min(capacity, currentTokens + tokensToAdd);

            lastRefillTime = currentTime;

            if (tokenAmount > currentTokens) {
                return Status.RATE_LIMIT_EXCEEDED;
            }

            currentTokens -= tokenAmount;
        } finally {
            lock.unlock();
        }
        return Status.SUCCESS;
    }

    /**
     * Segment 5 coding problem: N requests/sec, burst of size B, reject excess.
     */
    public static void main(String[] args) throws InterruptedException {
        int nPerSecond = 5;
        int burstCapacity = 10;
        RateBucket limiter = new RateBucket(burstCapacity, nPerSecond);

        // Burst: 12 instant requests -> at most B succeed, excess rejected
        int burstSuccess = 0;
        for (int i = 0; i < 12; i++) {
            if (limiter.request(1f) == Status.SUCCESS) {
                burstSuccess++;
            }
        }
        System.out.println("burst: " + burstSuccess + " allowed, " + (12 - burstSuccess) + " rejected (B=" + burstCapacity + ")");
        if (burstSuccess != burstCapacity) {
            throw new AssertionError("expected " + burstCapacity + " successes, got " + burstSuccess);
        }

        // Sustain: after 1 second the bucket refills N tokens
        Thread.sleep(1000);
        int refillSuccess = 0;
        for (int i = 0; i < nPerSecond; i++) {
            if (limiter.request(1f) == Status.SUCCESS) {
                refillSuccess++;
            }
        }
        System.out.println("after 1s: " + refillSuccess + "/" + nPerSecond + " requests allowed (N=" + nPerSecond + "/s)");
        if (refillSuccess != nPerSecond) {
            throw new AssertionError("expected " + nPerSecond + " refilled requests, got " + refillSuccess);
        }

        // Bucket is empty again -> excess rejected
        if (limiter.request(1f) != Status.RATE_LIMIT_EXCEEDED) {
            throw new AssertionError("expected rejection after refill consumed");
        }
        System.out.println("segment 5 demo passed");
    }
}

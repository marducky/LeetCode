package knowledge.multiProcess.chapter4;

import java.util.concurrent.locks.ReentrantLock;

public class FairNoFairDemo {
    private ReentrantLock lock;

    public FairNoFairDemo(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void fairNoFairDemoMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " get the lock!");

        } finally {
            lock.unlock();
        }
    }
}

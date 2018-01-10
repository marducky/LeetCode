//ReadReadShare
package knowledge.multiProcess.chapter4;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockWriteWriteLockDemo {
    ReentrantReadWriteLock lockDemo = new ReentrantReadWriteLock();

    public void read() {
        try {
            try {
                lockDemo.writeLock().lock();
                System.out.println(" get the read lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } finally {
                lockDemo.readLock().unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


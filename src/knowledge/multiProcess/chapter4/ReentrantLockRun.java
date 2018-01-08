package knowledge.multiProcess.chapter4;

public class ReentrantLockRun {
    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ReentrantLockOne r1 = new ReentrantLockOne(reentrantLockDemo);
        ReentrantLockOne r2 = new ReentrantLockOne(reentrantLockDemo);
        ReentrantLockOne r3 = new ReentrantLockOne(reentrantLockDemo);
        ReentrantLockOne r4 = new ReentrantLockOne(reentrantLockDemo);
        ReentrantLockOne r5 = new ReentrantLockOne(reentrantLockDemo);
        r1.start();
        try {
            r1.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r2.start();
        r3.start();
        r4.start();
        r5.start();
    }
}

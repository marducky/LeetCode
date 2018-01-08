package knowledge.multiProcess.chapter4;

public class ReentrantLockOne extends Thread {
    private ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

    public ReentrantLockOne(ReentrantLockDemo reentrantLockDemo) {
        super();
        this.reentrantLockDemo = reentrantLockDemo;
    }

    @Override
    public void run() {
        reentrantLockDemo.testMethod();
    }
}

package knowledge.multiProcess.chapter4;

public class ReentrantReadWriteLockDemoOne extends Thread {
    private ReentrantReadWriteLockReadReadShareDemo reentrantReadWriteLockDemo;

    public ReentrantReadWriteLockDemoOne(ReentrantReadWriteLockReadReadShareDemo reentrantReadWriteLockDemo) {
        super();
        this.reentrantReadWriteLockDemo = reentrantReadWriteLockDemo;
    }

    @Override
    public void run() {
        reentrantReadWriteLockDemo.read();
    }

}

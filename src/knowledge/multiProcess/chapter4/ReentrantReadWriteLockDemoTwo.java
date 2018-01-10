package knowledge.multiProcess.chapter4;

public class ReentrantReadWriteLockDemoTwo extends Thread {
    private ReentrantReadWriteLockReadReadShareDemo reentrantReadWriteLockDemo;

    public ReentrantReadWriteLockDemoTwo(ReentrantReadWriteLockReadReadShareDemo reentrantReadWriteLockDemo) {
        super();
        this.reentrantReadWriteLockDemo = reentrantReadWriteLockDemo;
    }

    @Override
    public void run() {
        reentrantReadWriteLockDemo.read();
    }

}

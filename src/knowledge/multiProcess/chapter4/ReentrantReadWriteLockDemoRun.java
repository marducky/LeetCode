package knowledge.multiProcess.chapter4;

public class ReentrantReadWriteLockDemoRun {
    public static void main(String[] args) {
        ReentrantReadWriteLockReadReadShareDemo reentrantReadWriteLockDemo = new ReentrantReadWriteLockReadReadShareDemo();
        ReentrantReadWriteLockDemoOne one = new ReentrantReadWriteLockDemoOne(reentrantReadWriteLockDemo);
        one.setName("One");
        ReentrantReadWriteLockDemoTwo two = new ReentrantReadWriteLockDemoTwo(reentrantReadWriteLockDemo);
        two.setName("Two");
        one.start();
        two.start();
    }
}

package knowledge.multiProcess.chapter3;

public class WaitMethodLockStillOne extends Thread {
    private Object lock;
    public WaitMethodLockStillOne(Object lock){
        super();
        this.lock=lock;
    }
    @Override
    public void run(){
        WaitMethodLockStill waitMethodLockStill=new WaitMethodLockStill();
        waitMethodLockStill.testMethod(lock);
    }
}

package knowledge.multiProcess.chapter3;

public class WaitMethodLockStillTwo extends Thread {
    private Object lock;
    public WaitMethodLockStillTwo(Object lock){
        super();
        this.lock=lock;
    }
    @Override
    public void run(){
        WaitMethodLockStill waitMethodLockStill=new WaitMethodLockStill();
        waitMethodLockStill.testMethod(lock);
    }
}

package knowledge.multiProcess.chapter3;

public class WaitMethodLockStillRun {
    public static void main(String[] args){
        Object lock=new Object();
        WaitMethodLockStillOne waitMethodLockStillOne=new WaitMethodLockStillOne(lock);
        waitMethodLockStillOne.start();
        WaitMethodLockStillTwo waitMethodLockStillTwo=new WaitMethodLockStillTwo(lock);
        waitMethodLockStillTwo.start();
    }
}

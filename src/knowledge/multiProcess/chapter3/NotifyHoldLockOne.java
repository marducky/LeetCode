package knowledge.multiProcess.chapter3;

public class NotifyHoldLockOne extends Thread {
    private Object lock;
    public NotifyHoldLockOne(Object lock){
        super();
        this.lock=lock;
    }
    @Override
    public void run(){
        NotifyHoldLock notifyHoldLock=new NotifyHoldLock();
        notifyHoldLock.testMethod(lock);
    }

}

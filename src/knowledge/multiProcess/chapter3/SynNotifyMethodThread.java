package knowledge.multiProcess.chapter3;

public class SynNotifyMethodThread extends Thread {
    private Object lock;
    public SynNotifyMethodThread(Object lock){
        super();
        this.lock=lock;
    }
    @Override
    public void run(){
        NotifyHoldLock notifyHoldLock=new NotifyHoldLock();
        notifyHoldLock.synNotifyMethod(lock);
    }

}

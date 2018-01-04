package knowledge.multiProcess.chapter3;

public class NotifyHoldLockRun {
    public static void main(String[] args){
        Object lock=new Object();
        NotifyHoldLockOne notifyHoldLockOne=new NotifyHoldLockOne(lock);
        notifyHoldLockOne.start();
        NotifyThread notifyThread=new NotifyThread(lock);
        notifyThread.start();
        SynNotifyMethodThread synNotifyMethodThread=new SynNotifyMethodThread(lock);
        synNotifyMethodThread.start();
    }
}

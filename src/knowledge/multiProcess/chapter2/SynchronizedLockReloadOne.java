package knowledge.multiProcess.chapter2;

public class SynchronizedLockReloadOne extends Thread{
    @Override
    public void run(){
        SynchronizedLockReload synchronizedLockReload=new SynchronizedLockReload();
        synchronizedLockReload.synService1();
    }
}

package knowledge.multiProcess.chapter3;

public class NotifyHoldLock {
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println(" begin wait thread name"+Thread.currentThread().getName());
                lock.wait();
                System.out.println(" end wait thread name"+ Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void synNotifyMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println(" begin notify() Thread name"+Thread.currentThread().getName()+" time = "+System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                System.out.println(" end notify() Thread name"+Thread.currentThread().getName()+" time = "+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

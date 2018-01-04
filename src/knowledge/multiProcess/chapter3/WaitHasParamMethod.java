package knowledge.multiProcess.chapter3;

public class WaitHasParamMethod {
    static private Object lock=new Object();
    static private Runnable runnable1=new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock){
                    System.out.println(" wait begin time="+System.currentTimeMillis());

                    lock.wait(5000);
                    System.out.println(" end begin time="+System.currentTimeMillis());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
    public static void main(String[] args){
        Thread thread=new Thread(runnable1);
        thread.start();
    }
}

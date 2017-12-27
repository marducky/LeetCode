package knowledge.multiProcess.chapter2;

public class DeadLockTest implements Runnable {
    public String username;
    public Object lock1=new Object();
    public Object lock2=new Object();
    public void setFlag(String username){
        this.username=username;
    }
    @Override
    public void run(){
        if (username.equals("a")){
            synchronized (lock1){
                try {
                    System.out.println("username= "+ username);
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("an lock1->lock2 to run");
                }
            }
        }
        if (username.equals("b")){
            synchronized (lock2){
                try {
                    System.out.println("username= "+ username);
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("an lock2->lock1 to run");
                }
            }
        }

    }
    public static void main(String [] args){
        try {
            DeadLockTest deadLockTest1=new DeadLockTest();
            deadLockTest1.setFlag("a");
            Thread thread1=new Thread(deadLockTest1);
            thread1.start();
            Thread.sleep(100);
            deadLockTest1.setFlag("b");
            Thread thread2=new Thread(deadLockTest1);
            thread2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

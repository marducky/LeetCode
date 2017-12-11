package knowledge.multiProcess.chapter1;

public class CurrentThreadTest extends Thread{
    public CurrentThreadTest(){
        System.out.println("con method "+Thread.currentThread().getName());
    }
    @Override
    public void run(){
        System.out.println("override method "+Thread.currentThread().getName());
    }
    public static void main(String [] args){
        System.out.println("main method "+Thread.currentThread().getName());
        CurrentThreadTest currentThreadTest1=new CurrentThreadTest();
        currentThreadTest1.run();
        CurrentThreadTest currentThreadTest2=new CurrentThreadTest();
        currentThreadTest2.start();
    }
}

package knowledge.multiProcess.chapter2;

public class SynchronizedCycleForForOne extends Thread{
//    synchronized public void methodA(){
//        System.out.println("MethodA begin");
//        boolean isContinueRun=true;
//        while (isContinueRun){
//
//        }
//        System.out.println("MethodA end");
//    }
//    synchronized public void methodB(){
//        System.out.println("MethodB begin");
//        System.out.println("MethodB end");
//    }
    private SynchronizedCycleForFor synchronizedCycleForFor;
    public SynchronizedCycleForForOne(SynchronizedCycleForFor synchronizedCycleForFor){
        super();
        this.synchronizedCycleForFor=synchronizedCycleForFor;
    }
    @Override
    public void run(){
        synchronizedCycleForFor.methodA();
    }

}
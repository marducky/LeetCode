package knowledge.multiProcess.chapter2;

public class SynchronizedCycleForForUpdateOne extends Thread{
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
    private SynchronizedCycleForForUndate synchronizedCycleForForUndate;
    public SynchronizedCycleForForUpdateOne(SynchronizedCycleForForUndate synchronizedCycleForForUndate){
        super();
        this.synchronizedCycleForForUndate=synchronizedCycleForForUndate;
    }
    @Override
    public void run(){
        synchronizedCycleForForUndate.methodA();
    }

    //    synchronized public void methodB(){
//        System.out.println("MethodB begin");
//        System.out.println("MethodB end");

}

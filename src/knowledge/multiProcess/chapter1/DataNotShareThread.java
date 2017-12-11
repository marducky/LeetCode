package knowledge.multiProcess.chapter1;

public class DataNotShareThread extends Thread{
    private int count=5;
    public DataNotShareThread(String name){
        super();
        this.setName(name);
    }
    @Override
    public void run(){
        super.run();
        while (count>0){
            count--;
            System.out.println(" 由 "+this.currentThread().getName()+" 计算 , count="+count);
        }
    }
    public static void main(String[] args){
        DataNotShareThread dataNotShareThread1=new DataNotShareThread("A");
//        DataNotShareThread dataNotShareThread2=new DataNotShareThread("B");
//        DataNotShareThread dataNotShareThread3=new DataNotShareThread("C");
        Thread a=new Thread(dataNotShareThread1,"A");
        Thread b=new Thread(dataNotShareThread1,"B");
        Thread c=new Thread(dataNotShareThread1,"C");
        Thread d=new Thread(dataNotShareThread1,"D");
        Thread e=new Thread(dataNotShareThread1,"E");
//        dataNotShareThread1.start();
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
//        dataNotShareThread2.start();
//        dataNotShareThread3.start();
    }
}

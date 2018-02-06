package knowledge.multiProcess.chapter3;

//import javaInherit.util.ArrayList;
//import javaInherit.util.List;

public class TwoThreadTransDataTwo extends Thread{
    private TwoThreadTransData twoThreadTransData;
    public TwoThreadTransDataTwo(TwoThreadTransData twoThreadTransData){
        super();
        this.twoThreadTransData=twoThreadTransData;
    }
    @Override
    public void run(){
        try {
//            for (int i=0;i<10;i++){
//                twoThreadTransData.add();
//                System.out.println("添加了"+(i+1)+"个元素");
//                Thread.sleep(1000);
            while (true){
                if (twoThreadTransData.size()==5){
                    System.out.println("==5了，线程b要退出了");
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

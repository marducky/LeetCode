package knowledge.multiProcess.chapter3;

//import javaInherit.util.ArrayList;
//import javaInherit.util.List;

public class TwoThreadTransDataOne extends Thread{
    private TwoThreadTransData twoThreadTransData;
    public TwoThreadTransDataOne(TwoThreadTransData twoThreadTransData){
        super();
        this.twoThreadTransData=twoThreadTransData;
    }
    @Override
    public void run(){
        try {
            for (int i=0;i<10;i++){
                twoThreadTransData.add();
                System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

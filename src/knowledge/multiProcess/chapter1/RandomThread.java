package knowledge.multiProcess.chapter1;

public class RandomThread extends Thread{
    @Override
    public void run(){
        try{
            for (int i=0;i<10;i++){
                int time=(int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try{
            RandomThread randomThread=new RandomThread();
            randomThread.setName("RandomThread");
            randomThread.start();
            for (int i=0;i<10;i++){
                int time=(int)(Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

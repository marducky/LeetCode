package knowledge.multiProcess.chapter1;

public class IsLiveTest extends Thread{
    @Override
    public void run(){
        System.out.println("run ="+this.isAlive());
    }
    public static void main(String[] args){
        IsLiveTest isLiveTest=new IsLiveTest();
        System.out.println("begin =="+isLiveTest.isAlive());
        isLiveTest.start();
        System.out.println("end =="+isLiveTest.isAlive());
    }
}

package knowledge.multiProcess.chapter1;

public class MyThread extends Thread {
    @Override
    public void run(){
        super.run();
        System.out.print("Thread: myThread. ");
    }
    public static void main(String[] args){
        MyThread myThread=new MyThread();
//        myThread.start();
        for (int i=0;i<1;i++){
            myThread.start();
        }
        System.out.println("main: Done the Process. ");
    }
}

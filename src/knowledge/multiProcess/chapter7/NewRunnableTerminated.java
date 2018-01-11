package knowledge.multiProcess.chapter7;

public class NewRunnableTerminated extends Thread {
    public NewRunnableTerminated() {
        System.out.println("the construct method state: " + Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("run method state: " + Thread.currentThread().getState());
    }
}

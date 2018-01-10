package knowledge.multiProcess.chapter6;

public class FatSingletonOne extends Thread {
    @Override
    public void run() {
        System.out.println(FatSingleton.getInstance().hashCode());
    }
}

package knowledge.multiProcess.chapter6;

public class DCLForSafeSingletonOne extends Thread {
    @Override
    public void run() {
        System.out.println(DCLForSafeSingleton.getInstance().hashCode());
    }
}

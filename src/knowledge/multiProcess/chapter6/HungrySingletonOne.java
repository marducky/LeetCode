package knowledge.multiProcess.chapter6;

public class HungrySingletonOne extends Thread {
    @Override
    public void run() {
        System.out.println(HungrySingleton.getInstance().hashCode());
    }
}

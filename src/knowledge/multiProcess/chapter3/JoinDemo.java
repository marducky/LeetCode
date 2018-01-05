package knowledge.multiProcess.chapter3;

public class JoinDemo extends Thread {
    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 1000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

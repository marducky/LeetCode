package knowledge.multiProcess.chapter3;

public class SleepHoldLockTwo extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(" two run time begin time" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" two end time  end  time" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void twoService() {
        System.out.println(" print the twoService time" + System.currentTimeMillis());
    }
}

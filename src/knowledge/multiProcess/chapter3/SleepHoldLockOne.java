package knowledge.multiProcess.chapter3;

public class SleepHoldLockOne extends Thread {
    private SleepHoldLockTwo sleepHoldLockTwo;

    public SleepHoldLockOne(SleepHoldLockTwo sleepHoldLockTwo) {
        super();
        this.sleepHoldLockTwo = sleepHoldLockTwo;

    }

    @Override
    public void run() {
        try {
            synchronized (sleepHoldLockTwo) {
                sleepHoldLockTwo.start();
                Thread.sleep(6000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

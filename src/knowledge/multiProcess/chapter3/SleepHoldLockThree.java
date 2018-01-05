package knowledge.multiProcess.chapter3;

public class SleepHoldLockThree extends Thread {
    private SleepHoldLockTwo sleepHoldLockTwo;

    public SleepHoldLockThree(SleepHoldLockTwo sleepHoldLockTwo) {
        super();
        this.sleepHoldLockTwo = sleepHoldLockTwo;
    }

    @Override
    public void run() {
        sleepHoldLockTwo.twoService();
    }
}

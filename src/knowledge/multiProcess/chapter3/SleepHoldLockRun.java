package knowledge.multiProcess.chapter3;

public class SleepHoldLockRun {
    public static void main(String[] args) {
        try {
            SleepHoldLockTwo sleepHoldLockTwo = new SleepHoldLockTwo();
            SleepHoldLockOne sleepHoldLockOne = new SleepHoldLockOne(sleepHoldLockTwo);
            Thread.sleep(1000);
            sleepHoldLockOne.start();
            SleepHoldLockThree sleepHoldLockThree = new SleepHoldLockThree(sleepHoldLockTwo);
            sleepHoldLockThree.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package knowledge.multiProcess.chapter7;

public class SleepTimedWaitedRun {
    public static void main(String[] args) {
        try {
            SleepTimedWaited sleepTimedWaited = new SleepTimedWaited();
            sleepTimedWaited.setName("aaaaa");
            sleepTimedWaited.start();
            Thread.sleep(1000);
            System.out.println(" main方法中的状态： " + sleepTimedWaited.getName() + " :" + sleepTimedWaited.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

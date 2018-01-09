package knowledge.multiProcess.chapter4;

public class UseConditionWaitNotifyTrueRUn {
    public static void main(String[] args) {
        UseConditionWaitNotifyTrue useConditionWaitNotifyTrue = new UseConditionWaitNotifyTrue();
        UseConditionWaitNotifyTrueOne useConditionWaitNotifyTrueOne = new UseConditionWaitNotifyTrueOne(useConditionWaitNotifyTrue);
        useConditionWaitNotifyTrueOne.start();
        try {
            useConditionWaitNotifyTrueOne.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Yes! the thread sleep!");
    }
}

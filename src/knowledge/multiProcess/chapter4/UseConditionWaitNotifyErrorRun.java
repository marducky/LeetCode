package knowledge.multiProcess.chapter4;

public class UseConditionWaitNotifyErrorRun {
    public static void main(String[] args) {
        UseConditionWaitNotifyError useConditionWaitNotifyError = new UseConditionWaitNotifyError();
        UseConditionWaitNotifyErrorOne useConditionWaitNotifyErrorOne = new UseConditionWaitNotifyErrorOne(useConditionWaitNotifyError);
        useConditionWaitNotifyErrorOne.start();
    }
}

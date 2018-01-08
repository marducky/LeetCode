package knowledge.multiProcess.chapter4;

public class UseConditionWaitNotifyTrueOne extends Thread {
    private UseConditionWaitNotifyTrue useConditionWaitNotifyTrue;

    public UseConditionWaitNotifyTrueOne(UseConditionWaitNotifyTrue useConditionWaitNotifyTrue) {
        super();
        this.useConditionWaitNotifyTrue = useConditionWaitNotifyTrue;
    }

    @Override
    public void run() {
        useConditionWaitNotifyTrue.waitMethod();
    }
}

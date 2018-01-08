package knowledge.multiProcess.chapter4;

public class UseConditionWaitNotifyErrorOne extends Thread {
    private UseConditionWaitNotifyError useConditionWaitNotifyError;

    public UseConditionWaitNotifyErrorOne(UseConditionWaitNotifyError useConditionWaitNotifyError) {
        super();
        this.useConditionWaitNotifyError = useConditionWaitNotifyError;

    }

    @Override
    public void run() {
        useConditionWaitNotifyError.await();
    }
}


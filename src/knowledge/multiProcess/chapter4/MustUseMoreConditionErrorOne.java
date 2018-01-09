package knowledge.multiProcess.chapter4;

public class MustUseMoreConditionErrorOne extends Thread {
    private MustUseMoreConditionError mustUseMoreConditionError;

    public MustUseMoreConditionErrorOne(MustUseMoreConditionError mustUseMoreConditionError) {
        super();
        this.mustUseMoreConditionError = mustUseMoreConditionError;
    }

    @Override
    public void run() {
        mustUseMoreConditionError.awaitA();
    }
}

package knowledge.multiProcess.chapter4;

public class MustUseMoreConditionErrorTwo extends Thread {
    private MustUseMoreConditionError mustUseMoreConditionError;

    public MustUseMoreConditionErrorTwo(MustUseMoreConditionError mustUseMoreConditionError) {
        super();
        this.mustUseMoreConditionError = mustUseMoreConditionError;
    }

    @Override
    public void run() {
        mustUseMoreConditionError.awaitB();
    }
}

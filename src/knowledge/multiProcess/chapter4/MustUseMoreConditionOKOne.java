package knowledge.multiProcess.chapter4;

public class MustUseMoreConditionOKOne extends Thread {
    private MustUseMoreConditionOK mustUseMoreConditionOK;

    public MustUseMoreConditionOKOne(MustUseMoreConditionOK mustUseMoreConditionOK) {
        super();
        this.mustUseMoreConditionOK = mustUseMoreConditionOK;
    }

    @Override
    public void run() {
        mustUseMoreConditionOK.awaitA();
    }
}

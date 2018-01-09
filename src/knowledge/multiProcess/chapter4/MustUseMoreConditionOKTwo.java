package knowledge.multiProcess.chapter4;

public class MustUseMoreConditionOKTwo extends Thread {
    private MustUseMoreConditionOK mustUseMoreConditionOK;

    public MustUseMoreConditionOKTwo(MustUseMoreConditionOK mustUseMoreConditionOK) {
        super();
        this.mustUseMoreConditionOK = mustUseMoreConditionOK;
    }

    @Override
    public void run() {
        mustUseMoreConditionOK.awaitB();
    }
}

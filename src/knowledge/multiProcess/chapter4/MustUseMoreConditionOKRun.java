package knowledge.multiProcess.chapter4;

public class MustUseMoreConditionOKRun {
    public static void main(String[] args) throws InterruptedException {
        MustUseMoreConditionOK mustUseMoreConditionOK = new MustUseMoreConditionOK();
        MustUseMoreConditionOKOne one = new MustUseMoreConditionOKOne(mustUseMoreConditionOK);
        one.setName("A");
        one.start();
        MustUseMoreConditionOKTwo two = new MustUseMoreConditionOKTwo(mustUseMoreConditionOK);
        two.setName("B");
        two.start();
        Thread.sleep(3000);
        mustUseMoreConditionOK.signalAll_A();
        mustUseMoreConditionOK.signalAll_B();
    }
}

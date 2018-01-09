package knowledge.multiProcess.chapter4;

public class MustUseMoreConditionErrorRun {
    public static void main(String[] args) throws InterruptedException {
        MustUseMoreConditionError mustUseMoreConditionError = new MustUseMoreConditionError();
        MustUseMoreConditionErrorOne one = new MustUseMoreConditionErrorOne(mustUseMoreConditionError);
        one.setName("A");
        one.start();
        MustUseMoreConditionErrorTwo two = new MustUseMoreConditionErrorTwo(mustUseMoreConditionError);
        two.setName("B");
        two.start();
        Thread.sleep(3000);
        mustUseMoreConditionError.signalAll();
    }
}

package knowledge.multiProcess.chapter2;

public class HasSelfPrivateNumOne extends Thread{
    private HasSelfPrivateNum hasSelfPrivateNum;
    public HasSelfPrivateNumOne(HasSelfPrivateNum hasSelfPrivateNum){
        super();
        this.hasSelfPrivateNum=hasSelfPrivateNum;
    }
    @Override
    public void run(){
        super.run();
        hasSelfPrivateNum.addI("a");
    }
}

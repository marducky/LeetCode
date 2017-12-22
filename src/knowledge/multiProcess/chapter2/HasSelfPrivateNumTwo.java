package knowledge.multiProcess.chapter2;

public class HasSelfPrivateNumTwo extends Thread{
    private HasSelfPrivateNum hasSelfPrivateNum;
    public HasSelfPrivateNumTwo(HasSelfPrivateNum hasSelfPrivateNum){
        super();
        this.hasSelfPrivateNum=hasSelfPrivateNum;
    }
    @Override
    public void run(){
        super.run();
        hasSelfPrivateNum.addI("b");
    }
}

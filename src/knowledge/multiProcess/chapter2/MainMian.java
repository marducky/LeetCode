package knowledge.multiProcess.chapter2;

public class MainMian {
    public static void main(String[] args){
        HasSelfPrivateNum numRef=new HasSelfPrivateNum();
        HasSelfPrivateNumOne hasSelfPrivateNumOne=new HasSelfPrivateNumOne(numRef);
        hasSelfPrivateNumOne.start();
        HasSelfPrivateNumTwo hasSelfPrivateNumTwo=new HasSelfPrivateNumTwo(numRef);
        hasSelfPrivateNumTwo.start();
    }
}

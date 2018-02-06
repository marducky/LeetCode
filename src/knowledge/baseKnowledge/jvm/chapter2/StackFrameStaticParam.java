package knowledge.baseKnowledge.jvm.chapter2;

public class StackFrameStaticParam {
    public static void main(String[] args){
        byte[] bytes=new byte[64*1024*1024];
        int a=0;
        System.gc();
    }

}

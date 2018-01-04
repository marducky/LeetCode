//http://blog.csdn.net/zq602316498/article/details/38926607
package majors.jvm.chapter2;

public class StackFrameStaticParamTwo {
    public static void main(String[] args){
        byte[] bytes=new byte[64*1024*1024];
        int a=0;
        System.gc();
    }

}

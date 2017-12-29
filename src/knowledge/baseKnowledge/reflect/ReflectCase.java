package knowledge.baseKnowledge.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectCase {
    public static void main(String[] args)throws Exception{
        Proxy target=new Proxy();
        Method method=Proxy.class.getDeclaredMethod("run");
        method.invoke(target);
    }
    static class Proxy{
        public void run(){
            System.out.println("run");
        }

    }
}

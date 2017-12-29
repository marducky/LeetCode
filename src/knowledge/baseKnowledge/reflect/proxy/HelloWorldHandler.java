package knowledge.baseKnowledge.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author :Janus
 */

public class HelloWorldHandler implements InvocationHandler {
    private Object obj;
    public HelloWorldHandler(Object obj){
        super();
        this.obj=obj;
    }
    /**
     * @param proxy 代理类
     * @param method 被代理的方法
     * @param args
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        doBefore();
        result=method.invoke(obj,args);
        doAfter();
        return result;
    }
    public void doBefore(){
        System.out.println("before method invoke");
    }
    public void doAfter(){
        System.out.println("after methond invoke");
    }
}

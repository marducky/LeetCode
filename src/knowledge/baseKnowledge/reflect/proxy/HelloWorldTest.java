/***
 * Java动态代理一——动态类Proxy的使用 - Ruthless - 博客园 http://www.cnblogs.com/linjiqin/archive/2011/02/18/1957600.html
 */
package knowledge.baseKnowledge.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HelloWorldTest {
    public static void main(String[] args){
        HelloWorld helloWorld=new HelloWorldIml();
        InvocationHandler handler=new HelloWorldHandler(helloWorld);
        //create the proxy
        HelloWorld proxy=(HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),helloWorld.getClass().getInterfaces(),handler);
        proxy.sayHelloWorld();
    }
}

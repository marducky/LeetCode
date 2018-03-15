package majors.spring4.helloSpring.helloworld.impl;

import majors.spring4.helloSpring.helloworld.HelloWorld;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/15 14:35
 **/
public class StrutsHelloWorld implements HelloWorld {
    @Override
    public void sayHello() {
        System.out.println("Struts Say Hello!!");
    }
}

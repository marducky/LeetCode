package majors.spring4.helloSpring;

import majors.spring4.helloSpring.helloworld.HelloWorld;
import majors.spring4.helloSpring.helloworld.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/15 14:36
 **/
public class HelloProgram {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("majors/spring4/spring.xml");

        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");

        HelloWorld hw = service.getHelloWorld();

        hw.sayHello();
    }
}


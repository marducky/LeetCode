package majors.spring4.helloSpring.helloworld;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/15 14:34
 **/
public class HelloWorldService {
    private HelloWorld helloWorld;

    public HelloWorldService() {

    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

}

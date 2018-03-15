package majors.spring4.springYibai;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/15 14:27
 **/
public class HelloWorldService {
    private Helloword helloword;

    public HelloWorldService() {
        this.helloword = new StrutsHelloWorld();
    }
    //显而易见的是 HelloWorldService 类管理创建 HelloWorld 对象。
}

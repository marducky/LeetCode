package knowledge.baseKnowledge._javaCore.javaClass;

/**
 * @project: knowledge.baseKnowledge._javaCore.javaClass
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/28 13:28
 **/
public class InitialOrderTest {
    public static String staticField = "   StaticField";
    public String fieldFromMethod = getStrFromMethod();
    public String fieldFromInit = "   InitField";

    static {
        System.out.println("Call Init Static Code");
        System.out.println(staticField);
    }

    {
        System.out.println("Call Init Block Code");
        System.out.println(fieldFromInit);
        System.out.println(fieldFromMethod);
    }

    public InitialOrderTest() {
        System.out.println("Call Constructor");
    }

    public String getStrFromMethod() {
        System.out.println("Call getStrFromMethod Method");
        return "   MethodField";
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}

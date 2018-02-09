package knowledge.baseKnowledge._javaCore.javaHighLevel;

import java.util.Random;

/**
 * @project: knowledge.baseKnowledge._javaCore.javaHighLevel
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/07 16:26
 **/
class JavaFinalClassMethodParamPerson {
    private String name;

    JavaFinalClassMethodParamPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class JavaFinalClassMethodParam {

    private final String final_01 = "chenssy";    //编译期常量，必须要进行初始化，且不可更改
    private final String final_02;                //构造器常量，在实例化一个对象时被初始化

    private static Random random = new Random();
    private final int final_03 = random.nextInt(50);    //使用随机数来进行初始化

    //引用
    public final JavaFinalClassMethodParamPerson final_04 = new JavaFinalClassMethodParamPerson("chen_ssy");    //final指向引用数据类型

    JavaFinalClassMethodParam(String final_02) {
        this.final_02 = final_02;
    }

    public String toString() {
        return "final_01 = " + final_01 + "   final_02 = " + final_02 + "   final_03 = " + final_03 +
                "   final_04 = " + final_04.getName();
    }

    public static void main(String[] args) {
        System.out.println("------------第一次创建对象------------");
        JavaFinalClassMethodParam final1 = new JavaFinalClassMethodParam("cm");
        System.out.println(final1);
        System.out.println("------------第二次创建对象------------");
        JavaFinalClassMethodParam final2 = new JavaFinalClassMethodParam("zj");
        System.out.println(final2);
        System.out.println("------------修改引用对象--------------");
        final2.final_04.setName("chenssy");
        System.out.println(final2);
    }
}
/**
 * 编译期常量
 * 运行期初始化
 * final数据、final方法、final类、final参数
 */

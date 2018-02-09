package knowledge.baseKnowledge._javaCore.javaHighLevel;

/**
 * @project: knowledge.baseKnowledge._javaCore.javaHighLevel
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/07 16:24
 **/
public class JavaForTheStaticAndCode {
    /**
     * 静态代码块
     */
    static {
        System.out.println("执行静态代码块...");
    }

    /**
     * 构造代码块
     */ {
        System.out.println("执行构造代码块...");
    }

    /**
     * 无参构造函数
     */
    public JavaForTheStaticAndCode() {
        System.out.println("执行无参构造函数...");
    }

    /**
     * 有参构造函数
     *
     * @param id
     */
    public JavaForTheStaticAndCode(String id) {
        System.out.println("执行有参构造函数...");
    }

    public static void main(String[] args) {
        System.out.println("----------------------");
        new JavaForTheStaticAndCode();
        System.out.println("----------------------");
        new JavaForTheStaticAndCode("1");
    }
}
//静态代码块 > 构造代码块 > 构造函数。
/**
 * ----------------------
 * 执行构造代码块...
 * 执行无参构造函数...
 * ----------------------
 * 执行构造代码块...
 * 执行有参构造函数...
 */
//https://www.cnblogs.com/dolphin0520/p/3799052.html
//　　static关键字是很多朋友在编写代码和阅读代码时碰到的比较难以理解的一个关键字，也是各大公司的面试官喜欢在面试时问到的知识点之一。下面就先讲述一下static关键字的用法和平常容易误解的地方，最后列举了一些面试笔试中常见的关于static的考题。以下是本文的目录大纲：
//　　“static方法就是没有this的方法。在static方法内部不能调用非静态方法，反过来是可以的。而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用static方法。这实际上正是static方法的主要用途。”
//方便在没有创建对象的情况下来进行调用（方法/变量）。
package knowledge.baseKnowledge.keyMapKn.staticKn;

public class StaticDemo {
    private static int inPPP = 0;

    public StaticDemo(int inPPP) {
        System.out.println(inPPP);
    }

    public StaticDemo() {
        System.out.println(inPPP);
    }

    public static int getInPPP() {
        return inPPP;
    }

    public static void setInPPP(int inPPP) {
        StaticDemo.inPPP = inPPP;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String string = "2323da";

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo(222);
        StaticDemo staticDemo2 = new StaticDemo();
//        System.out.println(staticDemo);
    }
}

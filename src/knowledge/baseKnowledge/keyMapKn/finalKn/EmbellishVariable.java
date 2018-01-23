//修饰变量是final用得最多的地方，也是本文接下来要重点阐述的内容。首先了解一下final变量的基本语法：

//对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
package knowledge.baseKnowledge.keyMapKn.finalKn;

public class EmbellishVariable {
    public final String finalString = "00";
    private static long finalLong = 1;


    //can't resolve the setFinalString .

    public String getFinalString() {
        return finalString;
    }

    private static void testFInaInt() {
        for (int i = 0; i < 10; i++) {
            finalLong++;
        }
    }

    public static void main(String[] args) {
//        EmbellishVariable e=new EmbellishVariable();
        testFInaInt();
        System.out.println("::::" + finalLong + ":::::");

    }
}

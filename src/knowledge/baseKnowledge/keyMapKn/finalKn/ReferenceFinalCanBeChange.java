package knowledge.baseKnowledge.keyMapKn.finalKn;

class ReferenceDemoInt {
    public int anInt = 0;
}

public class ReferenceFinalCanBeChange {
    public static void main(String[] args) {
        final ReferenceDemoInt referenceDemoInt = new ReferenceDemoInt();
        System.out.println(++referenceDemoInt.anInt);
    }

}
//这段代码可以顺利编译通过并且有输出结果，输出结果为1。这说明引用变量被final修饰之后，虽然不能再指向其他对象，但是它指向的对象的内容是可变的。

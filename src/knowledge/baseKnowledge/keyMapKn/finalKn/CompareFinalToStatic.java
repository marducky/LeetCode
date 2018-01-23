package knowledge.baseKnowledge.keyMapKn.finalKn;

public class CompareFinalToStatic {
    public static void main(String[] args) {
        CompareFinalToStaticDemo compareFinalToStaticDemo1 = new CompareFinalToStaticDemo();
        CompareFinalToStaticDemo compareFinalToStaticDemo2 = new CompareFinalToStaticDemo();
        System.out.println(compareFinalToStaticDemo1.i);
        System.out.println(compareFinalToStaticDemo1.j);
        System.out.println(compareFinalToStaticDemo2.i);
        System.out.println(compareFinalToStaticDemo2.j);
    }
}

class CompareFinalToStaticDemo {
    public final double i = Math.random();
    public static double j = Math.random();
}

//result:
/**
 * 0.8909794288382689
 * 0.032179124167942885
 * 0.04667798804267198
 * 0.032179124167942885
 */

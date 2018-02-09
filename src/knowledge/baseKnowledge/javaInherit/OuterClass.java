package knowledge.baseKnowledge.javaInherit;

public class OuterClass {
    private String str;

    public void outerDisplay() {
        System.out.println("outerClass...");
    }

    public class InnerClass {
        public void innerDisplay() {
            //使用外围内的属性
            str = "chenssy...";
            System.out.println(str);
            //使用外围内的方法
            outerDisplay();
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.getInnerClass();
        inner.innerDisplay();
    }
}

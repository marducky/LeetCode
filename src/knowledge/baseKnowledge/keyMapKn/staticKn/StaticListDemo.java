package knowledge.baseKnowledge.keyMapKn.staticKn;

class StaticDemoSon extends StaticDemoParent {
    static {
        System.out.println("Son Static");
    }

    public StaticDemoSon() {
        System.out.println("Son Constructor");
    }
}

class StaticDemoParent {
    static {
        System.out.println("Parent Static");
    }

    public StaticDemoParent() {
        System.out.println("Parent Constructor");
    }
}

public class StaticListDemo {
    public static void main(String[] args) {
        StaticDemoSon staticDemoSon = new StaticDemoSon();
    }

    static {
        System.out.println("test static 1");
    }

    static {
        System.out.println("test static 2");
    }
}
//　　虽然在main方法中没有任何语句，但是还是会输出，原因上面已经讲述过了。另外，static块可以出现类中的任何地方（只要不是方法内部，记住，任何方法内部都不行），并且执行是按照static块的顺序执行的。

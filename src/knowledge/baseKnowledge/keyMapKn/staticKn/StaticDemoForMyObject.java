package knowledge.baseKnowledge.keyMapKn.staticKn;

//另外记住，即使没有显示地声明为static，类的构造器实际上也是静态方法
//　　static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。
////static成员变量的初始化顺序按照定义的顺序进行初始化。
class StaticDemoForMyObject {
    private static String string1 = "StaticProperty";
    private String string2 = "property";

    public StaticDemoForMyObject() {
    }

    public void print1() {
        System.out.println(string1);
        System.out.println(string2);
        //non-static method can use the static method.
        //and can use the static param.
        // but the static
        print2();
    }

    public static void print2() {
        System.out.println(string1);
//        System.out.println(string2);
        //Non-static field 'string2' cannot be referenced from a static context.
//        print1();
    }

    public static void main(String[] args) {
        StaticDemoForMyObject.print2();
    }
}

package knowledge.baseKnowledge.string;

public class StringDemo {
    public static void main(String[] args){
        String s="1213";
        System.out.println(s);
        System.out.println(s.substring(1,3));
        String s1="qwewreqrqer";
        s1=s1.replace('q','A');
        System.out.println(s1);
    }
}
//从上文可知String的成员变量是private final 的，也就是初始化之后不可改变。那么在这几个成员中， value比较特殊，因为他是一个引用变量，而不是真正的对象。value是final修饰的，也就是说final不能再指向其他数组对象，那么我能改变value指向的数组吗？ 比如将数组中的某个位置上的字符变为下划线“_”。 至少在我们自己写的普通代码中不能够做到，因为我们根本不能够访问到这个value引用，更不能通过这个引用去修改数组。
//那么用什么方式可以访问私有成员呢？ 没错，用反射， 可以反射出String对象中的value属性， 进而改变通过获得的value引用改变数组的结构。下面是实例代码：

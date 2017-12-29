package knowledge.baseKnowledge.string;

import java.lang.reflect.Field;

public class StringReflectionTest {
    public static void main(String[] args) throws Exception{
        String s="Hello World";
        System.out.println("s= "+s);
        Field valueFieldOfString=String.class.getDeclaredField("value");
        valueFieldOfString.setAccessible(true);
        char[] value=(char[])valueFieldOfString.get(s);
        value[5]='_';
        System.out.println("s= "+s);
    }
}
//在这个过程中，s始终引用的同一个String对象，但是再反射前后，这个String对象发生了变化， 也就是说，通过反射是可以修改所谓的“不可变”对象的。但是一般我们不这么做。这个反射的实例还可以说明一个问题：如果一个对象，他组合的其他对象的状态是可以改变的，那么这个对象很可能不是不可变对象。例如一个Car对象，它组合了一个Wheel对象，虽然这个Wheel对象声明成了private final 的，但是这个Wheel对象内部的状态可以改变， 那么就不能很好的保证Car对象不可变。
//
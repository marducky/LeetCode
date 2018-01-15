package knowledge.baseKnowledge.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class MayBeReflectSuccessDemo {
    private String name;
    private int age;

    public MayBeReflectSuccessDemo(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class MayBeReflectSuccess {
    public static void main(String[] args) {
        MayBeReflectSuccessDemo mayBeReflectSuccessDemo = new MayBeReflectSuccessDemo("22", 22);
        String mClass = mayBeReflectSuccessDemo.getClass().getName();
        try {
            Class c1 = Class.forName(mClass);
            Constructor constructor = c1.getDeclaredConstructor(String.class, int.class);
            Object instance = constructor.newInstance("Jake", 22);
            System.out.println(instance.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}

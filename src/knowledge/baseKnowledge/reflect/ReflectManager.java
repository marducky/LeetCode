package knowledge.baseKnowledge.reflect;


class ReflectManagerDemo {
    private String name;
    private int age;
    private long salary;

    {
        System.out.println("Begin the init!");
    }

    public ReflectManagerDemo(String name) {
        this.name = name;
        this.age = 20;
        this.salary = 3000;
    }

    public ReflectManagerDemo() {
        this.name = "Mike";
        this.age = 20;
        this.salary = 3000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public ReflectManagerDemo(String name, int age, long salary) {
        this.salary = salary;
        this.name = name;
        this.age = age;

    }
}

class ReflectEmployerDemo {
    private String name;
    private int age;
    private long salary;

    {
        System.out.println("Begin the init!");
    }

    public ReflectEmployerDemo(String name) {
        this.name = name;
        this.age = 20;
        this.salary = 3000;
    }

    public ReflectEmployerDemo() {
        this.name = "Mike";
        this.age = 20;
        this.salary = 3000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public ReflectEmployerDemo(String name, int age, long salary) {
        this.salary = salary;
        this.name = name;
        this.age = age;

    }
}

class ReflectStudentDemo {
}

public class ReflectManager {
    public static void main(String[] args) {
        ReflectManagerDemo reflectManagerDemo1 = new ReflectManagerDemo();
        ReflectManagerDemo reflectManagerDemo2 = new ReflectManagerDemo("Janus");
        ReflectManagerDemo reflectManagerDemo3 = new ReflectManagerDemo("Peter", 22, 3500);
        ReflectEmployerDemo reflectEmployerDemo1 = new ReflectEmployerDemo();
        ReflectEmployerDemo reflectEmployerDemo2 = new ReflectEmployerDemo("Jody");
        ReflectEmployerDemo reflectEmployerDemo3 = new ReflectEmployerDemo("Pebo", 23, 3200);
        System.out.println(reflectEmployerDemo1.getClass().getName() + "" + reflectEmployerDemo1.getName());
        System.out.println(reflectManagerDemo1.getClass().getName());
        Class c1 = reflectEmployerDemo2.getClass();
        String c1Name = c1.getName();
        System.out.println(c1Name);
        String classnameDemo = "knowledge.baseKnowledge.reflect.ReflectEmployerDemo";
        try {
            Class c2 = Class.forName(classnameDemo);
            System.out.println(c2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Object c3 = Class.forName(classnameDemo).newInstance();
            System.out.println("===============");
            System.out.println(c3.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String[] strings = new String[10];
        for (int i = 1; i < 10; i++) {
            strings[i] = 'i' + "'s'instance";
        }
        try {
            Object objects = Class.forName(classnameDemo).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

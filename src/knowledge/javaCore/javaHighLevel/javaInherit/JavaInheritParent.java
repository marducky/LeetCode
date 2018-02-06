package knowledge.javaCore.javaHighLevel.javaInherit;

public class JavaInheritParent {
    protected String name;
    protected int age;
    protected String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    JavaInheritParent(String name) {
        this.name = name;

        System.out.println("Parent Class Construct" + name);
    }
}

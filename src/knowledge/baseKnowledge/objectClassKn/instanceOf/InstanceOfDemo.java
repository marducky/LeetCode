package knowledge.baseKnowledge.objectClassKn.instanceOf;

import java.util.stream.Stream;

class EmployeeInstanceOf{
    private String name;
    private int age;
    private String address;
    {
        System.out.println("Cry");
    }
    EmployeeInstanceOf(){}
    EmployeeInstanceOf(String name,int age,String address){
        this.address=address;
        this.age=age;
        this.name=name;
        System.out.println("Get The IDer!");
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
}
public class InstanceOfDemo {
    public static void main(String[] args){
        //验证Class
        EmployeeInstanceOf employeeInstanceOf1=new EmployeeInstanceOf();
        EmployeeInstanceOf employeeInstanceOf2=new EmployeeInstanceOf("Janus",12,"ChengDu");
        boolean employeeInstanceOf1Result=employeeInstanceOf1 instanceof EmployeeInstanceOf;
        boolean employeeInstanceOf2Result=employeeInstanceOf2 instanceof EmployeeInstanceOf;
        System.out.println(employeeInstanceOf1Result);
        System.out.println(employeeInstanceOf2Result);
        //验证Object
        String string="sssss";
        boolean objectOfClass=string instanceof String;
        System.out.println(objectOfClass);

    }
}


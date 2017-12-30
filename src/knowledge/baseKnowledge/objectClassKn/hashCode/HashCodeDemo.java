package knowledge.baseKnowledge.objectClassKn.hashCode;

import java.util.HashMap;
import java.util.Map;

final class EmployeeHashCode{
    private String name;
    private int age;
    EmployeeHashCode(String name,int age){
        this.age=age;
        this.name=name;
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

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Object))
            return false;
        EmployeeHashCode e=(EmployeeHashCode) o;
        return e.getName().equals(name)&&e.getAge()==age;
    }
}
public class HashCodeDemo {
    public static void main(String [] args) {
        Map map = new HashMap<>();
        EmployeeHashCode emp = new EmployeeHashCode("Janus", 23);
        map.put(emp,"first employee");
        System.out.println(map.get(emp));
        System.out.println(map.get(new EmployeeHashCode("Janus",23)));

    }
}

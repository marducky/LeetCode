/**
 * 代码清单5给出了Employee、Address和CloneDemo类。Employee声明了name、age、address成员变量，是可以被克隆的类；Address声明了一个城市的地址并且其值是可变的。CloneDemo类驱动这个程序。
 CloneDemo的主函数main()创建了一个Employee对象并且对其进行克隆，然后，改变了原来的Employee对象中address值城市的名字。因为原来的Employee对象和其克隆出来的对象引用了相同的Address对象，所以两者都会提现出这个变化。
 */
package knowledge.baseKnowledge.objectClassKn;
class EmployeeClone implements Cloneable{
    private String name;
    private int age;
    private AddressClone addressClone;
    EmployeeClone(String name,int age,AddressClone addressClone){
        this.addressClone=addressClone;
        this.age=age;
        this.name=name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    AddressClone getAddressClone(){
        return  addressClone;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
class AddressClone{
    private String city;
    AddressClone(String city){
        this.city=city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
public class LowCloneCopy {
    public static void main(String[] args) throws CloneNotSupportedException{
        EmployeeClone employeeClone1=new EmployeeClone("Janus",24,new AddressClone("ChengDu"));
        System.out.printf("%s: %d: %s %n",employeeClone1.getName(),employeeClone1.getAge(),employeeClone1.getAddressClone().getCity());
//        EmployeeClone employeeClone2=new EmployeeClone("Janus",24,new AddressClone("ChengDu"));
        EmployeeClone employeeClone2=(EmployeeClone)employeeClone1.clone();
        System.out.printf("%s: %d: %s %n",employeeClone2.getName(),employeeClone2.getAge(),employeeClone2.getAddressClone().getCity());
        employeeClone2.getAddressClone().setCity("Chengdu");
        System.out.printf("%s: %d: %s%n",employeeClone1.getName(),employeeClone1.getAge(),employeeClone1.getAddressClone().getCity());
//        employeeClone2.getAddressClone().setCity("Chengdu");
        System.out.printf("%s: %d: %s%n",employeeClone2.getName(),employeeClone2.getAge(),employeeClone2.getAddressClone().getCity());

    }
}

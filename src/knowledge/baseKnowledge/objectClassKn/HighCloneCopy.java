/**
 * Java支持协变返回类型，代码清单6利用这个特性，在Employee类中覆盖父类clone()方法时，将返回类型从Object类的对象改为Employee类型。这样做的好处就是，Employee类之外的代码可以不用将这个类转换为Employee类型就可以对其进行复制。
 Employee类的clone()方法首先调用super().clone()，对name,age,address这些成员变量进行浅克隆。然后，调用成员变量Address对象的clone()来对其引用Address对象进行克隆。
 从Address类中的clone()函数可以看出，这个clone()和我们之前写的clone()有些不同：
 Address类没有实现Cloneable接口。因为只有在Object类中的clone()被调用时才需要实现，而Address是不会调用clone()的，所以没有实现Cloneable()的必要。
 这个clone()函数没有声明抛出CloneNotSupportedException。这个检查异常只可能在调用Object类clone()的时候抛出。clone()是不会被调用的，因此这个异常也就没有被处理或者传回调用处的必要了。
 Object类的clone()没有被调用(这里没有调用super.clone())。因为这不是对Address的对象进行浅克隆——只是一个成员变量复制而已。
 为了克隆Address的对象，需要创建一个新的Address对象并对其成员进行初始化操作。最后将新创建的Address对象返回。*/
package knowledge.baseKnowledge.objectClassKn;
class EmployeeCloneHigh implements Cloneable{
    private String name;
    private int age;
    private AddressCloneHigh addressCloneHigh;
    EmployeeCloneHigh(String name,int age,AddressCloneHigh addressCloneHigh){
        this.addressCloneHigh=addressCloneHigh;
        this.age=age;
        this.name=name;
    }
    @Override
    public EmployeeCloneHigh clone() throws CloneNotSupportedException{
        EmployeeCloneHigh employeeCloneHigh=(EmployeeCloneHigh) super.clone();
        employeeCloneHigh.addressCloneHigh=addressCloneHigh.clone();
        return employeeCloneHigh;
    }
    AddressCloneHigh getAddressClone(){
        return  addressCloneHigh;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class AddressCloneHigh{
    private String city;
    AddressCloneHigh(String city){
        this.city=city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public AddressCloneHigh clone(){
        return new AddressCloneHigh(new String(city));
    }
}

public class HighCloneCopy {
    public static void main(String[] args) throws CloneNotSupportedException{
        EmployeeCloneHigh employeeCloneHigh1=new EmployeeCloneHigh("Janus",24,new AddressCloneHigh("ChengDu"));
        System.out.printf("%s: %d: %s %n",employeeCloneHigh1.getName(),employeeCloneHigh1.getAge(),employeeCloneHigh1.getAddressClone().getCity());
//        EmployeeClone employeeClone2=new EmployeeClone("Janus",24,new AddressClone("ChengDu"));
        EmployeeCloneHigh employeeCloneHigh2=(EmployeeCloneHigh)employeeCloneHigh1.clone();
        System.out.printf("%s: %d: %s %n",employeeCloneHigh2.getName(),employeeCloneHigh2.getAge(),employeeCloneHigh2.getAddressClone().getCity());
        employeeCloneHigh2.getAddressClone().setCity("Chengdu");
        System.out.printf("%s: %d: %s%n",employeeCloneHigh1.getName(),employeeCloneHigh1.getAge(),employeeCloneHigh1.getAddressClone().getCity());
//        employeeClone2.getAddressClone().setCity("Chengdu");
        System.out.printf("%s: %d: %s%n",employeeCloneHigh2.getName(),employeeCloneHigh2.getAge(),employeeCloneHigh2.getAddressClone().getCity());

    }
}

//clone方法执行的是浅拷贝， 在编写程序时要注意这个细节。clone在平时项目的开发中可能用的不是很频繁，但是区分深拷贝和浅拷贝会让我们对java内存结构和运行方式有更深的了解。至于彻底深拷贝，几乎是不可能实现的，原因已经在上一节中进行了说明。深拷贝和彻底深拷贝，在创建不可变对象时，可能对程序有着微妙的影响，可能会决定我们创建的不可变对象是不是真的不可变。clone的一个重要的应用也是用于不可变对象的创建。关于创建不可变对象，我会在后续的文章中进行阐述，敬请期待
package knowledge.baseKnowledge.objectClassKn.clone;
class PersonDemo{
    private String name;
    private int age;
    PersonDemo(String name,int age){
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
}
public class CopyOrNew implements Cloneable{
    public static void main (String[] args){
        PersonDemo p=new PersonDemo("Janus",24);
        PersonDemo personDemo=p;
        System.out.println(p);
        System.out.println(personDemo);

        //可已看出，打印的地址值是相同的，既然地址都是相同的，那么肯定是同一个对象。p和p1只是引用而已，他们都指向了一个相同的对象Person(23, "zhang") 。 可以把这种现象叫做引用的复制。
        //栈区引用，堆区存储对象。由于age是基本数据类型， 那么对它的拷贝没有什么疑议，直接将一个4字节的整数值拷贝过来就行。但是name是String类型的， 它只是一个引用， 指向一个真正的String对象，那么对它的拷贝有两种方式： 直接将源对象中的name的引用值拷贝给新对象的name字段， 或者是根据原Person对象中的name指向的字符串对象创建一个新的相同的字符串对象，将这个新字符串对象的引用赋给新拷贝的Person对象的name字段。这两种拷贝方式分别叫做浅拷贝和深拷贝。深拷贝和浅拷贝的原理如下图所示：
    }
}

/**
 * 代码清单4声明了一个待克隆的Data类。这个类实现了Cloneable接口来防止调用clone()的时候抛出异常CloneNotSupportedException，声明了int型变量x，覆盖了clone()方法。这个方法通过执行super.clone()来调用父类的clone()(这个例子中是Object的)。通过覆盖来避免抛出CloneNotSupportedException异常。
 代码清单4也声明了一个CloneDemo类来实例化Data，并将其初始化，输出示例的值。然后克隆Data的对象，同样将其值输出。
 */
package knowledge.baseKnowledge.objectClassKn.clone;

public class CloneDemoData implements Cloneable{
    int x;
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public static void main(String[] args){
        CloneDemoData cloneDemo=new CloneDemoData();
        cloneDemo.x=5;
        System.out.printf("cd.x=%d%n",cloneDemo.x);
        try {
            CloneDemoData cloneDemo1=(CloneDemoData)cloneDemo.clone();
            System.out.printf("cd1.x=%d%n",cloneDemo1.x);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }


    }

}

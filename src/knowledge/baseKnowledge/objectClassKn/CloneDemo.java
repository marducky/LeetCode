/**
 * 上面的例子中，调用clone()的代码是位于被克隆的类(即CloneDemo类)里面的，所以就不需要覆盖clone()了。但是，如果调用别的类中的clone()，就需要覆盖clone()了。否则，将会看到“clone在Object中是被保护的”提示，因为clone()在Object中的权限是protected。(译者注：protected权限的成员在不同的包中，只有子类对象可以访问。代码清单3的CloneDemo类和代码清单4的Data类是Object类的子类，所以可以调用clone()，但是代码清单4中的CloneDemo类就不能直接调用Data父类的clone())。代码清单4在代码清单3上稍作修改来演示覆盖clone()。
 */
package knowledge.baseKnowledge.objectClassKn;

public class CloneDemo implements Cloneable{
    int x;
    public static void main(String[] args){
        CloneDemo cloneDemo=new CloneDemo();
        cloneDemo.x=5;
        System.out.printf("cd.x=%d%n",cloneDemo.x);
        try {
            CloneDemo cloneDemo1=(CloneDemo)cloneDemo.clone();
            System.out.printf("cd1.x=%d%n",cloneDemo1.x);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }


    }

}

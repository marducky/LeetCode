/**
 * 自反性：对于任意非空的引用值x，x.equals(x)返回值为真。
 对称性：对于任意非空的引用值x和y，x.equals(y)必须和y.equals(x)返回相同的结果。
 传递性：对于任意的非空引用值x,y和z,如果x.equals(y)返回真，y.equals(z)返回真，那么x.equals(z)也必须返回真。
 一致性：对于任意非空的引用值x和y，无论调用x.equals(y)多少次，都要返回相同的结果。在比较的过程中，对象中的数据不能被修改。
 对于任意的非空引用值x，x.equals(null)必须返回假。
 覆盖hashCode()函数
 当覆盖equals()函数的时候，就相当于覆盖了hashCode()函数，我将在下篇文章讨论hashCode()的时候详细说明。
 */
package knowledge.baseKnowledge.objectClassKn.equality;

import java.util.Arrays;

class EmployeeEqual{
    private String name;
    private int age;
    EmployeeEqual(String name,int age){
        this.name=name;
        this.age=age;
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
    public boolean equals(Object object){
        if (!(object instanceof EmployeeEqual))
            return false;
        EmployeeEqual employeeEqual=(EmployeeEqual) object;
        return employeeEqual.getName().equals(name)&&employeeEqual.getAge()==age;

    }
}
public class EqualDemo {
    public static void main(String[] args){
        EmployeeEqual employeeEqual1=new EmployeeEqual("Janus",24);
        EmployeeEqual employeeEqual2=new EmployeeEqual("Jerry",25);
        EmployeeEqual employeeEqual3=new EmployeeEqual("Janus",24);
        EmployeeEqual employeeEqual4=new EmployeeEqual("Janus",23+1);
        //验证自反性
        System.out.printf("Demonstrating reflexivity验证自反性...%n%n");
        System.out.printf("employeeEqual1 : %b%n",employeeEqual1.equals(employeeEqual1));
        //// 验证对称性。
        System.out.printf("%nDemonstrating symmetry验证对称性...%n%n");
        System.out.printf("employeeEqual1.equals(employeeEqual2): %b%n", employeeEqual1.equals(employeeEqual2));
        System.out.printf("employeeEqual2.equals(employeeEqual1): %b%n", employeeEqual2.equals(employeeEqual1));
        System.out.printf("employeeEqual1.equals(employeeEqual3): %b%n", employeeEqual1.equals(employeeEqual3));
        System.out.printf("employeeEqual3.equals(employeeEqual1): %b%n", employeeEqual3.equals(employeeEqual1));
        System.out.printf("employeeEqual2.equals(employeeEqual3): %b%n", employeeEqual2.equals(employeeEqual3));
        System.out.printf("employeeEqual3.equals(employeeEqual2): %b%n", employeeEqual3.equals(employeeEqual2));
        System.out.printf("employeeEqual3.equals(employeeEqual4): %b%n", employeeEqual3.equals(employeeEqual4));
        //// 验证传递性。
        System.out.printf("%nDemonstrating transitivity验证传递性...%n%n");
        System.out.printf("employeeEqual1.equals(employeeEqual3): %b%n", employeeEqual1.equals(employeeEqual3));
        System.out.printf("employeeEqual3.equals(employeeEqual4): %b%n", employeeEqual3.equals(employeeEqual4));
        System.out.printf("employeeEqual1.equals(employeeEqual4): %b%n", employeeEqual1.equals(employeeEqual4));
        // 验证一致性。
        System.out.printf("%nDemonstrating consistency验证一致性...%n%n");
        for(int i = 0; i <5; i++)
        {
            System.out.printf("e1.equals(e2): %b%n", employeeEqual1.equals(employeeEqual2));
            System.out.printf("e1.equals(e3): %b%n", employeeEqual1.equals(employeeEqual3));
        }
        // 验证传入非空集合时，返回值为false。
        System.out.printf("%nDemonstrating null check验证传入非空集合...%n%n");
        System.out.printf("e1.equals(null): %b%n", employeeEqual1.equals(null));

        //验证，尝试通过equals()函数来比较两个数组
        int x[] = { 1, 2, 3};
        int y[] = { 1, 2, 3};
        System.out.println("尝试通过equals()函数来比较两个数组");
        System.out.printf("x.equals(x): %b%n", x.equals(x));
        System.out.printf("x.equals(y): %b%n", x.equals(y));
        //由于equals()对数组来说比较的仅仅是引用，而不比较内容，所以x.equals(x)返回true（因为自反性——一个对象与它自己相等），但是x.equals(y)返回false。
        //可以使用java.util.Arrays 类中声明的 static boolean deepEquals(Object[] a1, Object[] a2) 方法来实现。
        Integer x1[]={1,3,2,4};
        Integer y1[]={1,3,2,4};
        Integer es1[]={1,2,3,4};
        System.out.println("Through the deepEqual to identify the In group.");
        System.out.printf("x1.equals(x1): %b%n", Arrays.deepEquals(x1,x1));
        System.out.printf("x1 equals(y1)； %b%n",Arrays.deepEquals(x1,y1));
        System.out.printf("x1 equals(es1)； %b%n",Arrays.deepEquals(x1,es1));
        //用deepEquals()方法比较的相等是“深度”的相等：这要求每个元素对象所包含的的成员、对象相等。成员对象如果还包含了对象，也要相等，以此类推，才算是“相等”（另外，两个空的数组引用也是“深度”的相等，因此Arrays.deepEquals(null, null)返回true）。
        System.out.println(Arrays.deepEquals(null,null));
    }
}

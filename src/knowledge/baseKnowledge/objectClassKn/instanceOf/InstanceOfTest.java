package knowledge.baseKnowledge.objectClassKn.instanceOf;


interface A {
}


class B implements A {
} //B是A的实现

class C extends B {
} //C继承B


class D {
}

public class InstanceOfTest {

    public static void main(String[] args) {
        A a = null;
        B b = null;
        boolean res;
        System.out.println("instanceoftest test case 1: ------------------");
        res = a instanceof A;
        System.out.println("a instanceof A: " + res); // a instanceof A:false
        res = b instanceof B;
        System.out.println("b instanceof B: " + res); // b instanceof B: false

        System.out.println("\ninstanceoftest test case 2: ------------------");
        a = new B();
        b = new B();
        res = a instanceof A;
        System.out.println("a instanceof A: " + res); // a instanceof A:true
        res = a instanceof B;
        System.out.println("a instanceof B: " + res); // a instanceof B:true
        res = b instanceof A;
        System.out.println("b instanceof A: " + res); // b instanceof A:true
        res = b instanceof B;
        System.out.println("b instanceof B: " + res); // b instanceof B:true

        System.out.println("\ninstanceoftest test case 3: ------------------");
        B b2 = new C();
        res = b2 instanceof A;
        System.out.println("b2 instanceof A: " + res); // b2 instanceof A:true
        res = b2 instanceof B;
        System.out.println("b2 instanceof B: " + res); // b2 instanceof A:true
        res = b2 instanceof C;
        System.out.println("b2 instanceof C: " + res); // b2 instanceof A:true


        System.out.println("\ninstanceoftest test case 4: ------------------");
        D d = new D();
        res = d instanceof A;
        System.out.println("d instanceof A: " + res); // d instanceof A:false
//        res = d instanceof B;
//        System.out.println("d instanceof B: " + res); // d instanceof B:false
//        res = d instanceof C;
//        System.out.println("d instanceof C: " + res); // d instanceof C:false
        res = d instanceof D;
        System.out.println("d instanceof D: " + res); // d instanceof D:true
    }

}
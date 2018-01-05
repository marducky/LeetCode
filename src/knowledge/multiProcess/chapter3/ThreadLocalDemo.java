/**
 * 总结：ThreadLocal不是为了解决多线程访问共享变量，而是为每个线程创建一个单独的变量副本，提供了保持对象的方法和避免参数传递的复杂性。
 * http://blog.csdn.net/lhqj1992/article/details/52451136
 * ThreadLocal的主要应用场景为按线程多实例（每个线程对应一个实例）的对象的访问，并且这个对象很多地方都要用到。例如：同一个网站登录用户，每个用户服务器会为其开一个线程，每个线程中创建一个ThreadLocal，里面存用户基本信息等，在很多页面跳转时，会显示用户信息或者得到用户的一些信息等频繁操作，这样多线程之间并没有联系而且当前线程也可以及时获取想要的数据。
 * ThreadLocal可以看做是一个容器，容器里面存放着属于当前线程的变量。ThreadLocal类提供了四个对外开放的接口方法，这也是用户操作ThreadLocal类的基本方法：
 * (1) void set(Object value)设置当前线程的线程局部变量的值。
 * (2) public Object get()该方法返回当前线程所对应的线程局部变量。
 * (3) public void remove()将当前线程局部变量的值删除，目的是为了减少内存的占用，该方法是JDK 5.0新增的方法。需要指出的是，当线程结束后，对应该线程的局部变量将自动被垃圾回收，所以显式调用该方法清除线程的局部变量并不是必须的操作，但它可以加快内存回收的速度。
 * (4) protected Object initialValue()返回该线程局部变量的初始值，该方法是一个protected的方法，显然是为了让子类覆盖而设计的。这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，并且仅执行1次，ThreadLocal中的缺省实现直接返回一个null。
 * 　在上面提到过，每个thread中都存在一个map, map的类型是ThreadLocal.ThreadLocalMap. Map中的key为一个threadlocal实例. 这个Map的确使用了弱引用,不过弱引用只是针对key. 每个key都弱引用指向threadlocal. 当把threadlocal实例置为null以后,没有任何强引用指向threadlocal实例,所以threadlocal将会被gc回收. 但是,我们的value却不能回收,因为存在一条从current thread连接过来的强引用. 只有当前thread结束以后, current thread就不会存在栈中,强引用断开, Current Thread, Map, value将全部被GC回收.
 * 　　所以得出一个结论就是只要这个线程对象被gc回收，就不会出现内存泄露，但在threadLocal设为null和线程结束这段时间不会被回收的，就发生了我们认为的内存泄露。其实这是一个对概念理解的不一致，也没什么好争论的。最要命的是线程对象不被回收的情况，这就发生了真正意义上的内存泄露。比如使用线程池的时候，线程结束是不会销毁的，会再次使用的。就可能出现内存泄露。
 */
package knowledge.multiProcess.chapter3;

public class ThreadLocalDemo {
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        if (threadLocal.get() == null) {
            System.out.println("never ...");
            threadLocal.set("my value");
        }
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
        ThreadLocal<String> tl = new ThreadLocal<String>();
        String str = tl.get();
        System.out.println("输出字符串:" + str);

        ThreadLocal<String> tl1 = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return "lp";
            }
        };
        String str1 = tl1.get();
        System.out.println("输出字符串:" + str1);

        ThreadLocal<String> tl2 = new ThreadLocal<String>();
        tl2.set("lp");
        String str2 = tl2.get();
        System.out.println("输出字符串:" + str2);

    }
}

//可重入锁的概念，自己可以获取自己的内部锁，比如在线程已经获得这个锁时，还没有释放，这时候在请求该锁，会立马得到该锁。
//可支持在父子类集成环境中。
package knowledge.multiProcess.chapter2;

public class SynchronizedLockReload {
    synchronized public void synService1(){
        System.out.println(" service 1 ");
        synService2();
    }
    synchronized public void synService2(){
        System.out.println(" service 2 ");
        synService3();
    }
    synchronized public void synService3(){
        System.out.println(" service 3 ");
    }
}

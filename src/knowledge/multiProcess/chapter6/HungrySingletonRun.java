package knowledge.multiProcess.chapter6;

public class HungrySingletonRun {
    public static void main(String[] args) {
        HungrySingletonOne singleton1 = new HungrySingletonOne();
        HungrySingletonOne singleton2 = new HungrySingletonOne();
        HungrySingletonOne singleton3 = new HungrySingletonOne();
        singleton1.start();
        singleton2.start();
        singleton3.start();
    }
}

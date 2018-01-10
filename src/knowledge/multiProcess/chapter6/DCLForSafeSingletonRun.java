package knowledge.multiProcess.chapter6;

public class DCLForSafeSingletonRun {
    public static void main(String[] args) {
        DCLForSafeSingletonOne singleton1 = new DCLForSafeSingletonOne();
        DCLForSafeSingletonOne singleton2 = new DCLForSafeSingletonOne();
        DCLForSafeSingletonOne singleton3 = new DCLForSafeSingletonOne();
        singleton1.start();
        singleton2.start();
        singleton3.start();
    }
}

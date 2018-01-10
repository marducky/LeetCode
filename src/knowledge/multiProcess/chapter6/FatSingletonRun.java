package knowledge.multiProcess.chapter6;

public class FatSingletonRun {
    public static void main(String[] args) {
        FatSingletonOne fatSingleton = new FatSingletonOne() {
        };
        FatSingletonOne fatSingleton1 = new FatSingletonOne() {
        };
        FatSingletonOne fatSingleton2 = new FatSingletonOne() {
        };
        fatSingleton.start();
        fatSingleton1.start();
        fatSingleton2.start();
        System.out.println("+++============+++");
        FatSingletonTwo fatSingleton11 = new FatSingletonTwo() {
        };
        FatSingletonTwo fatSingleton111 = new FatSingletonTwo() {
        };
        FatSingletonTwo fatSingleton12 = new FatSingletonTwo() {
        };
        fatSingleton11.start();
        fatSingleton111.start();
        fatSingleton12.start();
    }
}

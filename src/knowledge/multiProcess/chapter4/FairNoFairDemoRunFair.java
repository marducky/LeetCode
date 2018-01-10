package knowledge.multiProcess.chapter4;

public class FairNoFairDemoRunFair {
    public static void main(String[] args) throws InterruptedException {
        final FairNoFairDemo fairNoFairDemo = new FairNoFairDemo(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("※Thread " + Thread.currentThread().getName() + " running!");
                fairNoFairDemo.fairNoFairDemoMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}

package knowledge.multiProcess.chapter3;

import java.util.Random;

public class ThreadLocalActionDemoLongThread implements Runnable {
    private ThreadLocal<Long> local;
    private Long value;

    public ThreadLocalActionDemoLongThread(ThreadLocal<Long> local, Long value) {
        this.local = local;
        this.value = value;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            int sleepValue = (int) (Math.random() * 1000);
            int sleepValueTemp = new Random().nextInt(1000);
            Thread.sleep(sleepValueTemp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + ":" + local.get());
        System.out.println(threadName + ":value" + value);
        local.set(new Long(value + local.get()));
        System.out.println(threadName + ":final" + local.get());
    }

}

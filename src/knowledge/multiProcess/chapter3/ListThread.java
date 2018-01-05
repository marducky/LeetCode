package knowledge.multiProcess.chapter3;

import java.util.List;
import java.util.Random;

public class ListThread implements Runnable {
    private ThreadLocal<List<String>> local = new ThreadLocal<List<String>>();


    public ListThread(ThreadLocal<List<String>> local) {
        this.local = local;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + ":" + local.get());
        local.get().add(Thread.currentThread().getName());
        System.out.println(threadName + ": final " + local.get());
    }

}

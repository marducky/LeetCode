package majors.MQInAction.ProducterAndConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/27 13:09
 **/
public class Producter implements Runnable {
    private volatile boolean isRunning = true;
    //todo: learn to the methond;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();//总数，原子操作。
    private static final int SLEEPTIME = 1000;

    public Producter(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("Start producting id: " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + " 加入队列！ ");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("加入队列失败");
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}

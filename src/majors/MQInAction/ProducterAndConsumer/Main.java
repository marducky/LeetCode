package majors.MQInAction.ProducterAndConsumer;


import org.glassfish.grizzly.threadpool.Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/27 14:05
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<>(10);
        Producter producer1 = new Producter(queue);
        Producter producer2 = new Producter(queue);
        Producter producer3 = new Producter(queue);
        Producter producer4 = new Producter(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        Consumer consumer4 = new Consumer(queue);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(producer3);
        executorService.execute(producer4);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);
        executorService.execute(consumer4);
        Thread.sleep(1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();
        producer4.stop();
        Thread.sleep(3000);
        executorService.shutdown();

    }
}

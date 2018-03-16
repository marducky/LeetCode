package knowledge.baseKnowledge._javaCore.httpClientForMultiProcess;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/16 13:35
 **/
public class HttpPressTest {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(30);

        for (int index = 0; index < 1000000; index++) {

            final int NO = index;

            Runnable run = new Runnable() {

                public void run() {

                    try {
                        long time1 = System.currentTimeMillis();
                        URL url = new URL("http://www.Google.com");
                        InputStreamReader isr = new InputStreamReader(url.openStream());
                        long time2 = System.currentTimeMillis();
                        System.out.print("Thread " + NO + " time:" + (time2 - time1) + "ms");
                        BufferedReader br = new BufferedReader(isr);
                        String str;
                        while ((str = br.readLine()) != null) {
                            System.out.println(str);
                        }
                        br.close();
                        isr.close();

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                }

            };

            exec.execute(run);

        }

// 退出线程池

        exec.shutdown();

    }
}

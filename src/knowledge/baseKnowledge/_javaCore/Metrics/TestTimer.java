package knowledge.baseKnowledge._javaCore.Metrics;

/**
 * @project: knowledge.baseKnowledge._javaCore.Metrics
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/03/07 14:25
 * <p>
 * 作用：meter和histogram的组合体
 * <p>
 * 例如：统计某个函数的qps和执行耗时。
 * <p>
 * 线程安全：meter和histogram都安全，所以也线程安全
 */

/**
 * 作用：meter和histogram的组合体

 例如：统计某个函数的qps和执行耗时。

 线程安全：meter和histogram都安全，所以也线程安全
 */

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Timers
 * 作用：histogram和meter的组合体
 */
public class TestTimer {
    public static void main(String[] args) throws InterruptedException {
        MetricRegistry registry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(registry).build();
        reporter.start(1, TimeUnit.SECONDS);

        Timer timer = registry.timer(MetricRegistry.name(TestTimer.class, "get-latency"));
        Timer.Context ctx = timer.time();

        try {
            Thread.sleep(2000);
        } finally {
            ctx.stop();
        }
    }
}

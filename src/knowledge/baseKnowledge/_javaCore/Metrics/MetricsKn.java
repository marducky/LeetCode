package knowledge.baseKnowledge._javaCore.Metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;

import java.util.concurrent.TimeUnit;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/03/14 14:40
 **/
public class MetricsKn {
    private static final MetricRegistry metrics = new MetricRegistry();
    private final Meter requests = metrics.meter("requests");

    public void handleRequest(Request request, Response response) {
        requests.mark();
        // etc
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);

    }
}

package com.example.jjugdemo.metric;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Random;
/**
 * MicroProfile Metrics のデモ用のエンドポイント.
 */
@Path("/metric")
@ApplicationScoped //Required for @Gauge
public class MetricController {

    @Inject 
    @Metric(name = "endpoint_counter")
    private Counter counter;
    /**
    * ランダムな処理時間を持つエンドポイント.
    */
    @Path("timed")
    @Timed(name = "timed-request")
    @GET
    public String timedRequest() {
        // Demo, not production style
        int wait = new Random().nextInt(1000);
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            // Demo
            e.printStackTrace();
        }

        return "Request is used in statistics, check with the Metrics call.";
    }

    /**
    * カウンターをインクリメントするエンドポイント.
    */
    @Path("increment")
    @GET
    public long doIncrement() {
        counter.inc();
        return counter.getCount();
    }
    /**
     * カスタムのゲージを返すエンドポイント.
     */
    @Gauge(name = "counter_gauge", unit = MetricUnits.NONE)
    private long getCustomerCount() {
        return counter.getCount();
    }
}

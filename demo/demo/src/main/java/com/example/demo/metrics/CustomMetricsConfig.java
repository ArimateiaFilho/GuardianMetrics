package com.example.demo.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class CustomMetricsConfig {

    private static final Logger log = LoggerFactory.getLogger(CustomMetricsConfig.class);

    private final MeterRegistry registry;
    private final Random random = new Random();
    private final AtomicLong dbConnectionFailed = new AtomicLong(0);
    private final AtomicLong activeUsers = new AtomicLong(0);

    private final Counter failedRequestCount;

    private Boolean fakeMetrics = false;

    private Boolean fakeMetricsDB = false;

    public CustomMetricsConfig(MeterRegistry registry) {
        this.registry = registry;

        this.failedRequestCount = Counter.builder("requests_failed")
                .description("Requests Fail (Fake)")
                .tags("service", "demo-app")
                .register(registry);
    }

    @PostConstruct
    public void initGauges() {
        Gauge.builder("db_connection_failed", dbConnectionFailed, AtomicLong::get)
                .description("Connection Fail (Fake)")
                .tags("service", "demo-app")
                .register(registry);

        Gauge.builder("active_users", activeUsers, AtomicLong::get)
                .description("Activity Users (Fake)")
                .tags("service", "demo-app")
                .register(registry);
    }

    public void fakeMetricsUpdate(){
        fakeMetrics = !fakeMetrics;
    }

    public void fakeMetricsDBUpdate(){
        fakeMetricsDB = !fakeMetricsDB;
    }

    @Scheduled(fixedRate = 10000)
    public void updateFakeMetrics() {
        if(!fakeMetrics) {
            activeUsers.set(50 + random.nextInt(450));

            int fakeRequests = 1 + random.nextInt(10);
            for (int i = 0; i < fakeRequests; i++) {
                failedRequestCount.increment();
            }

            log.info("Fake Metrics Updated - ActiveUsers={}, +{} Requests", activeUsers.get(), fakeRequests);
        }else{
            activeUsers.set(0);
            log.info("No Fake Metrics");
        }
    }
    @Scheduled(fixedRate = 10000)
    public void updateFakeMetricsDB() {
        if(!fakeMetricsDB) {
            dbConnectionFailed.set(random.nextInt(5000));

            log.info("Fake Metrics Updated - DBFail={}", dbConnectionFailed.get());
        }else{
            dbConnectionFailed.set(0);
            log.info("No Fake Metrics on DataBase");
        }
    }
}

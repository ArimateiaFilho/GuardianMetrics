package com.example.demo.controller;

import com.example.demo.metrics.CustomMetricsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private CustomMetricsConfig metrics;

    @GetMapping("/change")
    public Map<String, Object> changeFakeMetrics() {
        metrics.fakeMetricsUpdate();
        return Map.of("status", "ok", "message", "fakeMetrics change");
    }

    @GetMapping("/change/db")
    public Map<String, Object> zeroMetricsFakeDBUpdate() {
        metrics.fakeMetricsDBUpdate();
        return Map.of("status", "ok", "message", "fakeMetricsDB change");
    }


}

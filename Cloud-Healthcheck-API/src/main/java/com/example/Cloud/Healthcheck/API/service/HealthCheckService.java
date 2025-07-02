package com.example.Cloud.Healthcheck.API.service;

import com.example.Cloud.Healthcheck.API.model.HealthCheckResult;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class HealthCheckService {
    public List<HealthCheckResult> checkUrls(List<String> urls) {
        List<HealthCheckResult> results = new ArrayList<>();
        for (String urlStr : urls) {
            long start = System.currentTimeMillis();
            try {
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(3500);
                conn.setReadTimeout(3500);
                conn.setRequestMethod("GET");
                conn.connect();
                int status = conn.getResponseCode();
                long latency = System.currentTimeMillis() - start;
                boolean up = status >= 200 && status < 400;
                results.add(new HealthCheckResult(urlStr, up, status, latency, null));
            } catch (Exception e) {
                long latency = System.currentTimeMillis() - start;
                results.add(new HealthCheckResult(urlStr, false, 0, latency, e.getMessage()));
            }
        }
        return results;
    }
}


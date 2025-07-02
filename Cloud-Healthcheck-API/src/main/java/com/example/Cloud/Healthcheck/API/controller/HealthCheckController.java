package com.example.Cloud.Healthcheck.API.controller;


import com.example.Cloud.Healthcheck.API.service.HealthCheckService;
import com.example.Cloud.Healthcheck.API.model.HealthCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    @Autowired
    private HealthCheckService service;

    @PostMapping("/check")
    public List<HealthCheckResult> check(@RequestBody Map<String, List<String>> body) {
        List<String> urls = body.get("urls");
        return service.checkUrls(urls);
    }

    // (Opcional) Endpoint GET para checar uma URL só:
    @GetMapping("/checkOne")
    public HealthCheckResult checkOne(@RequestParam String url) {
        return service.checkUrls(List.of(url)).get(0);
    }
}


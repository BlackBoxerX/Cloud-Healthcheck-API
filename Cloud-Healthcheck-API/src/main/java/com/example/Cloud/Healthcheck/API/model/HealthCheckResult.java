package com.example.Cloud.Healthcheck.API.model;

public class HealthCheckResult {
    private String url;
    private boolean up;
    private int statusCode;
    private long latencyMs;
    private String error;

    // Construtor padrão (necessário para o Jackson)
    public HealthCheckResult() {}

    // Construtor completo (opcional)
    public HealthCheckResult(String url, boolean up, int statusCode, long latencyMs, String error) {
        this.url = url;
        this.up = up;
        this.statusCode = statusCode;
        this.latencyMs = latencyMs;
        this.error = error;
    }

    // Getters e Setters obrigatórios para serialização JSON
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isUp() { return up; }
    public void setUp(boolean up) { this.up = up; }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public long getLatencyMs() { return latencyMs; }
    public void setLatencyMs(long latencyMs) { this.latencyMs = latencyMs; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
}



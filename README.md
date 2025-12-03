# GuardianMetrics
GuardianMetrics is an autonomous metrics-driven agent that continuously monitors system performance, detects anomalies, and executes automated actions to maintain stability. It integrates with Prometheus, Spring Boot Actuator, and custom metric emitters to provide intelligent, real-time operational responses.

## 🚀 Features

### 📊 **Metric Collection**
- Reads system and application metrics from:
  - Spring Boot Actuator (`/actuator/prometheus`)
  - Custom metrics (CPU, memory, DB connections, queue sizes, etc.)
  - Oracle DB connection pool insights (HikariCP)
  - Infrastructure or network metrics

### 🧠 **Metrics Intelligence Engine**
- Detects anomalies using:
  - Threshold-based rules
  - PromQL expressions
  - Rolling averages and trends
- Converts raw metrics into insights

### ⚡ **Automated Actions**
Based on interpretations, SentinelOps can:
- Restart components  
- Trigger webhooks (e.g., Slack, WhatsApp, n8n, PagerDuty)  
- Scale workloads  
- Reset internal system counters  
- Throttle or disable features  
- Run custom scripts  

### 🔐 **Secure Architecture**
- JWT-based authentication  
- Oracle database for persistence  

### 📈 **Prometheus Integration**
- Exposes metrics

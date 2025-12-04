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

# 🔐 **Authentication API**

### **POST `/auth/login`**
Authenticate a user and return a JWT token.

**Request body:**
```json
{
  "login": "admin",
  "password": "123456"
}
```

| Method | Endpoint        | Description              |
| ------ | --------------- | ------------------------ |
| POST   | `/users/create` | Create a new user        |
| GET    | `/users`        | List all users           |
| GET    | `/users/{id}`   | Retrieve a specific user |
| PUT    | `/users/{id}`   | Update a user            |
| DELETE | `/users/{id}`   | Delete a user            |

POST /users/create
{
  "login": "john",
  "password": "123",
  "role": "USER"
}

GET /change

Triggers general fake metrics update.
Response:
{
  "status": "ok",
  "message": "fakeMetrics change"
}

GET /change/db

Triggers database-related fake metrics update.
Response:
{
  "status": "ok",
  "message": "fakeMetricsDB change"
}

📈 Prometheus Metrics

GuardianMetrics exposes metrics at:

GET /actuator/prometheus

## Default Metrics:

process_cpu_usage
system_cpu_usage
jvm_memory_used_bytes
jvm_gc_pause_seconds_count
http_server_requests_seconds_count
http_server_requests_seconds_sum
http_server_requests_seconds_max
tomcat_sessions_active_current
logback_events_total

## Custom Metrics:

custom_requests_total
db_connection_failed
active_users

## Important:
The file resources.yaml is a Docker Compose configuration used to start Prometheus, n8n, and Oracle.
I did not include the application itself because it serves only as an example.
This project is just a prototype.
I plan to improve it and make it more capable and more accurate.

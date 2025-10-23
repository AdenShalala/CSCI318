# WareHost - Inventory Management System

A comprehensive inventory management system built with microservices architecture, featuring real-time analytics and AI-powered recommendations.

## System Architecture

WareHost is built using a microservices architecture with four independent services:

- **Inventory Service (8081)** - Stock management and tracking
- **Sales Service (8082)** - Sales tracking and management  
- **Promotions Service (8083)** - Promotions and discount management
- **AI Recommendation Service (8084)** - AI-powered recommendations using Gemini 2.0 Flash

## Quick Start

### Prerequisites

- **Java 17+**
- **Maven 3.6+**
- **Docker & Docker Compose** (for Kafka)

### 1. Start Kafka

```bash
# Start Kafka with Zookeeper
make kafka-up

# Verify Kafka is running
make kafka-status

### 1. Start Kafka

```bash
# Start Kafka with Zookeeper
make kafka-up

# Verify Kafka is running
make kafka-status
```

### 2. Build the Project

```bash
# Build all microservices and shared domain
mvn clean install
```

### 3. Start Microservices

Open separate terminals for each service:

```bash
# Terminal 1 - Inventory Service (8081)
cd /file_path/warehost
mvn spring-boot:run

# Terminal 2 - Sales Service (8082)  
cd /file_path/sales
mvn spring-boot:run

# Terminal 3 - Promotions Service (8083)
cd /file_path/promotions
mvn spring-boot:run

# Terminal 4 - AI Recommendation Service (8084)
cd /file_path/recommendationAgent
mvn spring-boot:run
```

### 4. Launch Web Interface
```
VS Code: right‑click → “Open with Live Server”.
```

## Service Endpoints

| Service | Port | Health Check | H2 Console |
|---------|------|--------------|------------|
| Inventory | 8081 | `http://localhost:8081/actuator/health` | `http://localhost:8081/h2-console` |
| Sales | 8082 | `http://localhost:8082/actuator/health` | `http://localhost:8082/h2-console` |
| Promotions | 8083 | `http://localhost:8083/actuator/health` | `http://localhost:8083/h2-console` |
| AI Recommendation | 8084 | `http://localhost:8084/actuator/health` | - |

## Project Structure

```
project/
├── warehost/                 # Inventory management service (8081)
├── sales/                    # Sales tracking service (8082)
├── promotions/               # Promotions service (8083)
├── recommendationAgent/      # AI recommendation service (8084)
├── sharedDomain/             # Shared events and DTOs
├── FrontEnd/                 # Web interface
│   ├── dashboard.html        # Main dashboard
│   ├── inventory.html        # Inventory management
│   ├── promotion.html        # Promotions management
│   ├── purchase-stock.html   # Stock purchasing
│   ├── resources.html        # Resource management
│   ├── ai-insights.html      # AI insights dashboard
│   └── assets/
│       ├── css/              # Stylesheets
│       └── js/               # JavaScript files
└── Makefile                  # Development utilities
```

## Configuration

### Kafka Topics

The system uses these Kafka topics:
- `sales.created` - Sales events
- `stock.low` - Low stock notifications  
- `promotions` - Promotion events

### Database

Each service uses an in-memory H2 database accessible via:
- No external database setup required
- Auto-configured with Spring Boot


## Key Features

### Real-time Inventory Management (8081)
- Add, remove, and track stock items
- Automatic stock level monitoring
- Real-time low stock notifications

### Sales Tracking (8082)
- Complete sales transaction management
- Charge and tax calculation
- Sales history and analytics

### Promotions Management (8083)
- Dynamic discount creation
- Promotion strategy planning
- Cross-service coordination

### AI-Powered Recommendations (8084)
- Stock suggestions based on current inventory
- Sales strategy recommendations
- Multi-agent system with Gemini 2.0 Flash

### Event-Driven Architecture
- Microservices communicate via Kafka events
- Real-time stock updates
- Automatic promotion triggering

## Development

### Building Services

```bash
# Build individual service
cd warehost
mvn clean package

# Build all services
mvn clean install
```

### Testing

```bash
# Run tests for a service
cd warehost
mvn test

# Run all tests
mvn test
```

### Kafka Management

```bash
# Start/stop Kafka
make kafka-up
make kafka-down

# View logs
make kafka-logs

# Create topics manually
make kafka-create-topic
```

## API Exampless

### Inventory Management (8081)
```bash
# Add item to inventory
curl -X POST http://localhost:8081/api/items \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop", "type":"Electronics", "quantity":10}'

# Get all items
curl http://localhost:8081/api/items
```

### Sales Tracking (8082)
```bash
# Create sale
curl -X POST http://localhost:8082/api/sales \
  -H "Content-Type: application/json" \
  -d '{"itemID":"item123", "quantity":1, "price":999.99}'
```

### AI Recommendations (8084)
```bash
# Get stock recommendations
curl -X POST http://localhost:8084/api/recommendations \
  -H "Content-Type: application/json" \
  -d '{"message":"What electronics should I stock?"}'
```

## Stopping Services

Always stop services in this order:

1. Stop microservices (Ctrl+C in each terminal)
2. Stop Kafka
```bash
make kafka-down
```

## Troubleshooting

### Common Issues

1. **Port conflicts**: Ensure ports 8081-8084 and 9092 are available
2. **Kafka connection**: Verify Kafka is running with `make kafka-status`
3. **AI features**: Gemini API key is pre-configured in application properties
4. **Database**: H2 consoles available at each service's `/h2-console` endpoint

### Verification

```bash
# Check all services are running
curl http://localhost:8081/actuator/health
curl http://localhost:8082/actuator/health
curl http://localhost:8083/actuator/health
curl http://localhost:8084/actuator/health

# Check Kafka topics
NEEEED TO ADDDD HEREEE
```

## Information
```
This project was submitted by Group 16 for CSIT318 Project.
Group 16:
    Aden Shalala
    Aalok Kumar Mandal
    Muhammad Ansari
    Henry Hocking
```
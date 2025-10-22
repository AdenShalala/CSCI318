# Makefile to manage local Kafka (Zookeeper + Kafka broker) via docker-compose

COMPOSE_FILE := docker-compose.kafka.yml

.PHONY: kafka-up kafka-down kafka-restart kafka-logs kafka-status kafka-create-topic kafka-exec

kafka-up:
	@echo "Starting Zookeeper + Kafka (detached)..."
	docker-compose -f $(COMPOSE_FILE) up -d
	@sleep 3
	@echo "Creating 'promotions' topic if missing (no-op if exists)..."
	- docker exec kafka bash -c "kafka-topics --bootstrap-server localhost:9092 --create --topic promotions --partitions 1 --replication-factor 1 || true"
	@echo "Kafka should be up (give it a few seconds to finish startup)."

kafka-down:
	@echo "Stopping Kafka + Zookeeper..."
	docker-compose -f $(COMPOSE_FILE) down

kafka-restart: kafka-down kafka-up

kafka-logs:
	docker-compose -f $(COMPOSE_FILE) logs -f

kafka-status:
	docker-compose -f $(COMPOSE_FILE) ps

kafka-create-topic:
	@echo "Creating 'promotions' topic (if not present)..."
	- docker exec kafka bash -c "kafka-topics --bootstrap-server localhost:9092 --create --topic promotions --partitions 1 --replication-factor 1 || true"

kafka-exec:
	docker exec -it kafka bash

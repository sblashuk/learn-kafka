DOCKER_COMPOSE_FILES = -f docker-compose.yml
DOCKER_COMPOSE = docker-compose ${DOCKER_COMPOSE_FILES}


run:
	${DOCKER_COMPOSE} up --build -d

stop:
	${DOCKER_COMPOSE} down

.PHONY: run stop

run-hw: DOCKER_COMPOSE_FILES += -f docker-compose.services.yml
run-hw:
	${DOCKER_COMPOSE} up --build -d

stop-hw: DOCKER_COMPOSE_FILES += -f docker-compose.services.yml
stop-hw:
	${DOCKER_COMPOSE} down

.PHONY: run-hw stop-hw

create-topic:
	docker exec broker \
		kafka-topics --bootstrap-server broker:9092 \
		--create \
		--replication-factor 1 --partitions 1 --topic quickstart

write-topic:
	docker exec --interactive --tty broker \
    	kafka-console-producer --bootstrap-server broker:9092 \
   		--topic hello-world

read-topic:
	docker exec --interactive --tty broker \
		kafka-console-consumer --bootstrap-server broker:9092 \
		--topic hello-world \
        --from-beginning

.PHONY: create-topic write-topic read-topic
.PHONY: all build test ping-mysql

all: build

up:
	@docker-compose up -d

build:
	@./gradlew build --warning-mode all

run-tests:
	@./gradlew test --warning-mode all

test:
	@docker exec socialapp-ddd_skeleton-java ./gradlew test --warning-mode all

run:
	@./gradlew :run

ping-mysql:
	@docker exec socialapp-java_ddd_skeleton-mysql mysqladmin --user=root --password= --host "127.0.0.1" ping --silent

# Start the app
start-rrss_backend:
	@./gradlew :run --args='rrss_backend server'


build:
	@mvn clean package
	@docker-compose build

run:
	@echo "After startup you can access the service at http://keycloak-nginx-proxy"
	@echo ""

	@./create_host.sh
	@docker-compose up

stop:
	@docker-compose down

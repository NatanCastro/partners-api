clean:
	./mvnw clean -q
run:
	set -xe
	make clean
	./mvnw package -q -T2
	java -jar target/*.jar
debug:
	set -xe
	./mvnw package -e
opendb:
	sudo docker exec -it mongodb bash -c 'mongosh -p root -u root --authenticationDatabase admin'
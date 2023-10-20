clean:
	./mvnw clean -q
run:
	set -xe
	make clean
	./mvnw package -q -e
	java -jar target/*.jar
opendb:
	sudo docker exec -it mongodb bash -c 'mongosh -p root -u root --authenticationDatabase admin'

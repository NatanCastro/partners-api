package dev.natan.ze.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "dev.natan.ze.challenge.infrastructure.db")
public class ZeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeChallengeApplication.class, args);
	}

}

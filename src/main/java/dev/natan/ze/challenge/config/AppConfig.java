package dev.natan.ze.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * AppConfig
 */
@Configuration
public class AppConfig {
  public @Bean MongoClient mongoClient() {
    return MongoClients.create("mongodb://root:root@localhost:27017/mydatabase?authSource=admin");
  }
}

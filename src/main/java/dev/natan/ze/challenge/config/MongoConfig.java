package dev.natan.ze.challenge.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    return "test";
  }

  @Override
  public MongoClient mongoClient() {
    ConnectionString connectionString = new ConnectionString("mongodb://root:root@localhost:27017/mydatabase?authSource=admin");
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();

    return MongoClients.create(mongoClientSettings);
  }

  @Override
  public Collection<String> getMappingBasePackages() {
    return Collections.singleton("dev.natan.ze.challenge");
  }
}

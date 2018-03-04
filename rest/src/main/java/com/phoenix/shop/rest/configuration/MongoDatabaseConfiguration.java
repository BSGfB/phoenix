package com.phoenix.shop.rest.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories("com.phoenix.shop.repository")
public class MongoDatabaseConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://phoenix:99538574@ds135156.mlab.com:35156/phoenix");
    }

    @Override
    protected String getDatabaseName() {
        return "phoenix";
    }
}

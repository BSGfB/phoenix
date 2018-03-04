package com.phoenix.shop.configuration

import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import com.phoenix.shop.repository.CityRepository
import com.phoenix.shop.service.CityServiceImpl
import com.phoenix.shop.service.api.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@PropertySource("classpath:mongo.properties")
@EnableReactiveMongoRepositories(basePackages = "com.phoenix.shop.repository")
class ServiceTestConfiguration extends AbstractReactiveMongoConfiguration {

    @Value('${mongo.url}')
    String url

    @Value('${mongo.user.username}')
    String username

    @Value('${mongo.user.password}')
    String password

    @Value('${mongo.name}')
    String name

    @Value('${mongo.port}')
    String port

    @Override
    MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://$username:$password@$url:$port/$name")
    }

    @Override
    protected String getDatabaseName() {
        return name
    }

    @Bean
    @Autowired
    CityService reactiveUserService(CityRepository cityRepository) {
        return new CityServiceImpl(cityRepository)
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

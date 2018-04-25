package com.phoenix.shop.rest.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.phoenix.shop.model.entity")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.phoenix.shop.repository"})
@Configuration
public class JpaConfiguration {
}

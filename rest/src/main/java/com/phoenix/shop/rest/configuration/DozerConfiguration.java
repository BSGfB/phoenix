package com.phoenix.shop.rest.configuration;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

    @Bean
    public Mapper dozerBeanMapper() {
        return DozerBeanMapperBuilder.buildDefault();
    }
}

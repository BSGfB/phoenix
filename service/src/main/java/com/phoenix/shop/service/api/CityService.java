package com.phoenix.shop.service.api;

import com.phoenix.shop.model.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityService {
    Mono<City> findByName(final String name);

    Mono<City> findById(final String id);

    Flux<City> findAll();
}

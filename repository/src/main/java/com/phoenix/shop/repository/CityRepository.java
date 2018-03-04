package com.phoenix.shop.repository;

import com.phoenix.shop.model.City;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CityRepository extends ReactiveCrudRepository<City, String> {
    Mono<City> findByName(final String name);
}

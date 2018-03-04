package com.phoenix.shop.service;

import com.phoenix.shop.model.City;
import com.phoenix.shop.repository.CityRepository;
import com.phoenix.shop.service.api.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Mono<City> findByName(final String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public Mono<City> findById(final String id) {
        return cityRepository.findById(id);
    }

    @Override
    public Flux<City> findAll() {
        return cityRepository.findAll();
    }
}

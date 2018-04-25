package com.phoenix.shop.service;

import com.phoenix.shop.model.response.RegionResponse;
import com.phoenix.shop.repository.RegionRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class RegionService {

    private final Mapper mapper;

    private final RegionRepository regionRepository;


    @Autowired
    public RegionService(final Mapper mapper, final RegionRepository regionRepository) {
        this.mapper = mapper;
        this.regionRepository = regionRepository;
    }

    public List<RegionResponse> findAll() {
        return regionRepository.findAll().stream()
                .map(entity -> mapper.map(entity, RegionResponse.class))
                .collect(toList());
    }
}

package com.phoenix.shop.service;

import com.phoenix.shop.model.response.CommonCategoryResponse;
import com.phoenix.shop.repository.CommonCategoryRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommonCategoryService {

    private final Mapper mapper;

    private final CommonCategoryRepository commonCategoryRepository;


    @Autowired
    public CommonCategoryService(final Mapper mapper, final CommonCategoryRepository commonCategoryRepository) {
        this.mapper = mapper;
        this.commonCategoryRepository = commonCategoryRepository;
    }

    public List<CommonCategoryResponse> findAll() {
        return commonCategoryRepository.findAll().stream()
                .map(entity -> mapper.map(entity, CommonCategoryResponse.class))
                .collect(toList());
    }
}

package com.phoenix.shop.rest.controller;

import com.phoenix.shop.model.response.CommonCategoryResponse;
import com.phoenix.shop.service.CommonCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CommonCategoryService commonCategoryService;

    @Autowired
    public CategoryController(final CommonCategoryService commonCategoryService) {
        this.commonCategoryService = commonCategoryService;
    }

    @GetMapping
    List<CommonCategoryResponse> findAll() {
        return commonCategoryService.findAll();
    }
}

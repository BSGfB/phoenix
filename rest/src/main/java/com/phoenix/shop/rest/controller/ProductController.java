package com.phoenix.shop.rest.controller;

import com.phoenix.shop.model.request.ProductRequest;
import com.phoenix.shop.model.response.ProductResponse;
import com.phoenix.shop.service.ProductService;
import com.phoenix.shop.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/save")
    @ApiOperation("Save new product")
    public Long save(@RequestBody ProductRequest product) {
        return productService.save(product);
    }

    @GetMapping(path = "/findAllMy")
    @ApiOperation("Find all my products product")
    public List<ProductResponse> findAllMy() {
        return productService.findAllMy();
    }
}

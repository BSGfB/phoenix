package com.phoenix.shop.model.request;

import com.phoenix.shop.model.plane.ProductType;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {
    private String title;

    private String description;

    private ProductType type;

    private Long categoryId;

    private Long cityId;

    private Long rubles;

    private Long pennies;

    private List<String> photos;
}

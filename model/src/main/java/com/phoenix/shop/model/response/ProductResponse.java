package com.phoenix.shop.model.response;

import com.phoenix.shop.model.plane.ProductType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponse {
    private String title;

    private String description;

    private ProductType type;

    private Long categoryId;

    private Long cityId;

    private Long rubles;

    private Long pennies;

    private LocalDateTime lastUpdate;

    private List<String> photos;
}

package com.phoenix.shop.model.response;

import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private Long commonCategoryId;
}

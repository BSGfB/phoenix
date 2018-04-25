package com.phoenix.shop.model.response;

import lombok.Data;

import java.util.List;

@Data
public class RegionResponse {
    private Long id;
    private String name;
    private List<CityResponse> cities;
}

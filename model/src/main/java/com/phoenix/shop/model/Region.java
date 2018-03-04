package com.phoenix.shop.model;

import lombok.Data;

import java.util.Collection;

@Data
public class Region {
    private String regionName;
    private Collection<City> cities;
}

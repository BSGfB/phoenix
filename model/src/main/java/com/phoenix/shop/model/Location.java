package com.phoenix.shop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document
public class Location {

    @Id
    private String id;
    private String countryName;
    private Collection<Region> regions;
}

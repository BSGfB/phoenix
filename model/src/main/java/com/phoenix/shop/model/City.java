package com.phoenix.shop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
@Data
public class City {

    @Id
    private String id;

    private String name;

    private Collection<String> postalCodes;
}

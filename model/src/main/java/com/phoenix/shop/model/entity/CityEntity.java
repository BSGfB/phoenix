package com.phoenix.shop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    @Column(name = "city_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "region_id")
    private Long regionId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(final Long regionId) {
        this.regionId = regionId;
    }
}

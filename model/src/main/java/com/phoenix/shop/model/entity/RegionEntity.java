package com.phoenix.shop.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "region")
public class RegionEntity {
    @Id
    @Column(name = "region_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "region_id")
    private List<CityEntity> cities;

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

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(final List<CityEntity> cities) {
        this.cities = cities;
    }
}

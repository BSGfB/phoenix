package com.phoenix.shop.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "common_category")
public class CommonCategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "common_category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "common_category_id")
    private List<CategoryEntity> categories;

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

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(final List<CategoryEntity> categories) {
        this.categories = categories;
    }
}

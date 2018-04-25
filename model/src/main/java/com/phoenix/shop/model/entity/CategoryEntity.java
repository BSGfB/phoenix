package com.phoenix.shop.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "common_category_id")
    private Long commonCategoryId;

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

    public Long getCommonCategoryId() {
        return commonCategoryId;
    }

    public void setCommonCategoryId(final Long commonCategoryId) {
        this.commonCategoryId = commonCategoryId;
    }
}

package com.phoenix.shop.model.entity;

import com.phoenix.shop.model.plane.ProductType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "rubles")
    private Long rubles;

    @Column(name = "pennies")
    private Long pennies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private List<PhotoEntity> photos;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(final ProductType type) {
        this.type = type;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(final Long cityId) {
        this.cityId = cityId;
    }

    public Long getRubles() {
        return rubles;
    }

    public void setRubles(final Long rubles) {
        this.rubles = rubles;
    }

    public Long getPennies() {
        return pennies;
    }

    public void setPennies(final Long pennies) {
        this.pennies = pennies;
    }

    public List<PhotoEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(final List<PhotoEntity> photos) {
        this.photos = photos;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(final UserEntity user) {
        this.user = user;
    }
}


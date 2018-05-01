package com.phoenix.shop.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class PhoneEntity {

    @Id
    @GeneratedValue
    @Column(name = "phone_id")
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(final Long userId) {
        this.userId = userId;
    }
}

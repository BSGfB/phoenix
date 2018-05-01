package com.phoenix.shop.model.response;

import com.phoenix.shop.model.plane.Phone;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserResponse {
    private Long userId;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private String photo;

    private List<Phone> phones;
}

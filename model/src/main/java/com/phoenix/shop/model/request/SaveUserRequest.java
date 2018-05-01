package com.phoenix.shop.model.request;

import com.phoenix.shop.model.plane.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaveUserRequest {
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private String photo;

    private Gender gender;

    private Long cityId;

    private List<String> phones;
}

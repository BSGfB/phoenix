package com.phoenix.shop.service;

import com.phoenix.shop.model.response.UserResponse;
import com.phoenix.shop.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Mapper mapper;

    private final UserRepository userRepository;


    @Autowired
    public UserService(final Mapper mapper, final UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public UserResponse findById(final Long id) {
        return userRepository
                .findById(id)
                .map(userEntity -> mapper.map(userEntity, UserResponse.class))
                .orElseThrow(() -> new IllegalArgumentException("User with id [" + id + "] not found"));
    }

}

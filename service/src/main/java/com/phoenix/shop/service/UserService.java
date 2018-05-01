package com.phoenix.shop.service;

import com.phoenix.shop.model.entity.PhoneEntity;
import com.phoenix.shop.model.entity.UserEntity;
import com.phoenix.shop.model.request.SaveUserRequest;
import com.phoenix.shop.model.response.UserResponse;
import com.phoenix.shop.repository.RoleRepository;
import com.phoenix.shop.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Mapper mapper;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(final Mapper mapper,
                       final UserRepository userRepository,
                       final RoleRepository roleRepository,
                       final PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse findById(final Long id) {
        return userRepository
                .findById(id)
                .map(userEntity -> mapper.map(userEntity, UserResponse.class))
                .orElseThrow(() -> new IllegalArgumentException("User with id [" + id + "] not found"));
    }

    public Long save(SaveUserRequest user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setRoles(Collections.singletonList(roleRepository.findByRoleName("USER")));
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        List<PhoneEntity> phones = user.getPhones()
                .stream()
                .map(phone -> {
                    PhoneEntity map = new PhoneEntity();
                    map.setPhoneNumber(phone);
                    map.setUser(userEntity);
                    return map;
                })
                .collect(Collectors.toList());
        userEntity.setPhones(phones);
        return userRepository.save(userEntity).getUserId();
    }
}

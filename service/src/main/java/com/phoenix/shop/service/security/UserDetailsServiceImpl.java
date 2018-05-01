package com.phoenix.shop.service.security;

import com.phoenix.shop.model.entity.UserEntity;
import com.phoenix.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username);
        String[] roles = user.getRoles().stream().map(role -> "ROLE_" + role.getRoleName()).toArray(String[]::new);

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(roles)
                .build();
    }
}

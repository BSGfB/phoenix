package com.phoenix.shop.repository.security;

import com.phoenix.shop.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrincipalRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}

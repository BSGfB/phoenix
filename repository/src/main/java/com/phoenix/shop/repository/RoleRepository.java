package com.phoenix.shop.repository;

import com.phoenix.shop.model.entity.RoleEntity;
import com.phoenix.shop.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByRoleName(String roleName);
}

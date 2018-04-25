package com.phoenix.shop.repository;

import com.phoenix.shop.model.entity.CommonCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCategoryRepository extends JpaRepository<CommonCategoryEntity, Long> {
}

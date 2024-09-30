package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.TopCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopCategoryRepository extends JpaRepository<TopCategory, Long> {

    boolean existsByCategoryName(String categoryName);
    Optional<TopCategory> findByCategoryName(String categoryName);
}

package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Long> {

    List<MiddleCategory> findByTopCategoryCategoryName(String topCategoryName);
    Optional<MiddleCategory> findByCategoryName(String categoryName);
    boolean existsByCategoryName(String categoryName);
}

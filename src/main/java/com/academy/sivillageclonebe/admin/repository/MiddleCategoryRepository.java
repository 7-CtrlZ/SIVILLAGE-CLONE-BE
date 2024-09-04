package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Long> {

    List<MiddleCategory> findByTopCategoryCategoryCode(String topCategoryCode);
    Optional<MiddleCategory> findByCategoryCode(String categoryCode);
    boolean existsByCategoryCode(String categoryCode);
}

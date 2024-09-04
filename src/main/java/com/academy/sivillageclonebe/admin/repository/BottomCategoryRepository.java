package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BottomCategoryRepository extends JpaRepository <BottomCategory, Long> {

    List<BottomCategory> findByMiddleCategoryCategoryCode(String middleCategoryCode);
    Optional<BottomCategory> findByCategoryCode(String categoryCode);
    boolean existsByCategoryCode(String categoryCode);
}

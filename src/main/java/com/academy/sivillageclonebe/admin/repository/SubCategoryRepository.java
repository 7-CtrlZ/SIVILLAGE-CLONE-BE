package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    List<SubCategory> findByBottomCategoryCategoryCode(String bottomCategoryCode);
    Optional<SubCategory> findByCategoryCode(String categoryCode);
    boolean existsByCategoryCode(String categoryCode);
}

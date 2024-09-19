package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByBottomCategoryCategoryName(String bottomCategoryName);
    Optional<SubCategory> findByCategoryName(String categoryName);
    boolean existsByCategoryName(String categoryName);
}

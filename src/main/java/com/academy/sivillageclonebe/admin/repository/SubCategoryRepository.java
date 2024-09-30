package com.academy.sivillageclonebe.admin.repository;

import com.academy.sivillageclonebe.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    List<SubCategory> findByBottomCategoryCategoryName(String bottomCategoryName);
    boolean existsByCategoryName(String categoryName);
}

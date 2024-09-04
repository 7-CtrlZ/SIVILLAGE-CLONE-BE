package com.academy.sivillageclonebe.admin.reponstity;

import com.academy.sivillageclonebe.admin.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    Optional<SubCategory> findByCategoryCode(String categoryCode);
    boolean existsByCategoryCode(String categoryCode);
}

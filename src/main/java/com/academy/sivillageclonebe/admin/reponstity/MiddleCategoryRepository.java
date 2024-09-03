package com.academy.sivillageclonebe.admin.reponstity;

import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Long> {

    Optional<MiddleCategory> findByCategoryCode(String categoryCode);
    boolean existsByCategoryCode(String categoryCode);
}

package com.academy.sivillageclonebe.admin.reponstity;

import com.academy.sivillageclonebe.admin.entity.TopCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopCategoryRepository extends JpaRepository<TopCategory, Long> {

    boolean existsByCategoryCode(String categoryCode);
    Optional<TopCategory> findByCategoryCode(String categoryCode);
}

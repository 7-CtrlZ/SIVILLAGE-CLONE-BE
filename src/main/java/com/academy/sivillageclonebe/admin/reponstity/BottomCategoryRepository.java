package com.academy.sivillageclonebe.admin.reponstity;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BottomCategoryRepository extends JpaRepository <BottomCategory, Long> {

    Optional<BottomCategory> findByCategoryCode(String categoryCode);
    boolean existsByCategoryCode(String categoryCode);
}

package com.academy.sivillageclonebe.admin.reponstity;

import com.academy.sivillageclonebe.admin.entity.BottomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BottomCategoryRepository extends JpaRepository <BottomCategory, Long> {
    boolean existsByCategoryCode(String categoryCode);
}

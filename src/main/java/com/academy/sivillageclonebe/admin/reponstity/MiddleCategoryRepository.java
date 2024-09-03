package com.academy.sivillageclonebe.admin.reponstity;

import com.academy.sivillageclonebe.admin.entity.MiddleCategory;
import com.academy.sivillageclonebe.admin.entity.TopCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Long> {

    boolean existsByCategoryCode(String categoryCode);
}

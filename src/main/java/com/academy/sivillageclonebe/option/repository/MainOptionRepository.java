package com.academy.sivillageclonebe.option.repository;

import com.academy.sivillageclonebe.option.entity.MainOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainOptionRepository extends JpaRepository<MainOption, Long> {

    boolean existsByMainOptionNameAndProduct_ProductCode(String productCode, String mainOptionName);
    List<MainOption> findByProduct_ProductCode(String productCode);

}

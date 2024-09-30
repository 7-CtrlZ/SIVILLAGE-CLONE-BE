package com.academy.sivillageclonebe.option.repository;

import com.academy.sivillageclonebe.option.entity.SubOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubOptionRepository extends JpaRepository<SubOption, Long> {

    boolean existsBySubOptionNameAndMainOptionId(String subOptionName, Long mainOptionId);
    List<SubOption> findByMainOptionId(Long mainOptionId);

}

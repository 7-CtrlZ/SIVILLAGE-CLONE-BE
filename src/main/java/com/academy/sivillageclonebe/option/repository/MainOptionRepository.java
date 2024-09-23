package com.academy.sivillageclonebe.option.repository;

import com.academy.sivillageclonebe.option.dto.MainOptionResponseDto;
import com.academy.sivillageclonebe.option.entity.MainOption;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainOptionRepository extends JpaRepository<MainOption, Long> {

//  List<MainOptionResponseDto> findByProduct_ProductCode(String productCode);
List<MainOption> findByProduct_ProductCode(String productCode);

}

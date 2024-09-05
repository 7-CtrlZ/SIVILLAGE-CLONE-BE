package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.vo.MiddleCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MiddleCategoryResponseDto {

    private String middleCategoryName;
    private String middleCategoryCode;
    private String topCategoryCode;

    public MiddleCategoryResponseVo toVo() {
        return MiddleCategoryResponseVo.builder()
                .middleCategoryName(middleCategoryName)
                .middleCategoryCode(middleCategoryCode)
                .topCategoryCode(topCategoryCode)
                .build();
    }
}

package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.vo.BottomCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BottomCategoryResponseDto {

    private String bottomCategoryName;
    private String bottomCategoryCode;
    private String middleCategoryCode;

    public BottomCategoryResponseVo toVo() {
        return BottomCategoryResponseVo.builder()
                .bottomCategoryCode(bottomCategoryCode)
                .bottomCategoryName(bottomCategoryName)
                .middleCategoryCode(middleCategoryCode)
                .build();
    }
}

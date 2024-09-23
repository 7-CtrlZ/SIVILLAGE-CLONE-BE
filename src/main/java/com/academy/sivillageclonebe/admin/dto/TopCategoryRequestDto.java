package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.TopCategory;
import com.academy.sivillageclonebe.admin.vo.TopCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryRequestDto {

    private String topCategoryName;

    public TopCategory toEntity() {
        return TopCategory.builder()
                .categoryName(topCategoryName)
                .build();
    }
}

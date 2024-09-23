package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.entity.TopCategory;
import com.academy.sivillageclonebe.admin.vo.TopCategoryResponseVo;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryResponseDto {

    private String topCategoryName;

    public TopCategoryResponseVo toVo() {
        return TopCategoryResponseVo.builder()
                .topCategoryName(topCategoryName)
                .build();
    }

}

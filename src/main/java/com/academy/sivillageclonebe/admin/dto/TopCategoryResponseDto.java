package com.academy.sivillageclonebe.admin.dto;

import com.academy.sivillageclonebe.admin.vo.TopCategoryResponseVo;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryResponseDto {

    private String topCategoryName;
    private String topCategoryCode;

    public TopCategoryResponseVo toVo() {
        return TopCategoryResponseVo.builder()
                .topCategoryName(topCategoryName)
                .topCategoryCode(topCategoryCode)
                .build();
    }

}

package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.vo.ProductStatusResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatusResponseDto {

    private Integer id;
    private String statusName;

    public ProductStatusResponseVo toVo() {
        return ProductStatusResponseVo.builder()
                .id(id)
                .statusName(statusName)
                .build();
    }
}

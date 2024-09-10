package com.academy.sivillageclonebe.vendor.dto;

import com.academy.sivillageclonebe.option.vo.BrandResponseVo;
import com.academy.sivillageclonebe.option.vo.ProductColorsResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandResponseDto {
    private String brandName;

    public BrandResponseVo toVo() {
        return BrandResponseVo.builder()
                .brandName(brandName)
                .build();
    }

}

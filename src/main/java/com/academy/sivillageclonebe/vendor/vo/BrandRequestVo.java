package com.academy.sivillageclonebe.vendor.vo;

import com.academy.sivillageclonebe.vendor.dto.BrandRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BrandRequestVo {

    private String brandName;

    public BrandRequestDto toDto() {
        return BrandRequestDto.builder()
                .brandName(brandName)
                .build();
    }
}

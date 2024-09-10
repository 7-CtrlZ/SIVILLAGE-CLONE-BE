package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandRequestDto {

    private String brandName;

    public Brand toEntity() {
        return Brand.builder()
                .brandName(brandName)
                .build();
    }

}

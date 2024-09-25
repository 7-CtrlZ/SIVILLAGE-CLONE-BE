package com.academy.sivillageclonebe.vendor.dto;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByCategoryResponseDto {

    private String productCode;

    public ProductByCategoryResponseVo toVo() {
        return ProductByCategoryResponseVo.builder()
                .productCode(productCode)
                .build();
    }

}

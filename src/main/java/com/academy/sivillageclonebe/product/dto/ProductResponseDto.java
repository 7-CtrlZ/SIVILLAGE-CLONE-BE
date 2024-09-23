package com.academy.sivillageclonebe.product.dto;

import com.academy.sivillageclonebe.option.dto.MainOptionResponseDto;
import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.product.vo.ProductResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private String productCode;
    private String brandName;
    private String productName;
    private Double price;
    private String productDescription;
    private String productDetailContent;
    private List<MainOptionResponseDto> mainOptionList;


    public ProductResponseVo toVo() {
        return ProductResponseVo.builder()
                .productCode(productCode)
                .brandName(brandName)
                .productName(productName)
                .price(price)
                .productDescription(productDescription)
                .productDetailContent(productDetailContent)
                .mainOptionList(mainOptionList)
                .build();
    }

}

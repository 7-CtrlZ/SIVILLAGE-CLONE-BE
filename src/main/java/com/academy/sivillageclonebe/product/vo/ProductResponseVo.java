package com.academy.sivillageclonebe.product.vo;

import com.academy.sivillageclonebe.option.dto.MainOptionResponseDto;
import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseVo {

    private String productCode;
    private String brandName;
    private String productName;
    private String productDescription;
    private String productDetailContent;
    private Double price;
    private List<MainOptionResponseDto> mainOptionList;
}

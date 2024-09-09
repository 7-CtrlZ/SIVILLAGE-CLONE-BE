package com.academy.sivillageclonebe.product.vo;

import com.academy.sivillageclonebe.product.dto.ProductByOptionDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseVo {

    private String productUuid;
    private String productCode;
    private String brandName;
    private String productName;
    private String productDescription;
    private String productDetailContent;
    private Double price;
    private List<ProductByOptionDto> productByOptionList;
}

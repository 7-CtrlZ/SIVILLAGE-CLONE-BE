package com.academy.sivillageclonebe.vendor.dto;

import com.academy.sivillageclonebe.vendor.entity.ProductByCategory;
import com.academy.sivillageclonebe.vendor.vo.ProductByCategoryResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductByCategoryResponseDto {

    private List<String> productCode;
    private Long lastId;
    private Integer size;
    private Boolean hasNext;

}

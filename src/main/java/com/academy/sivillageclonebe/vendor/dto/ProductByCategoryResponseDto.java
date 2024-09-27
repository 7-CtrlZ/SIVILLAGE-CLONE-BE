package com.academy.sivillageclonebe.vendor.dto;

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

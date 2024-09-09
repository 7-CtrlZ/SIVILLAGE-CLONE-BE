package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductStatusRequestDto {

    private String statusName;

    public ProductStatus toEntity() {
        return ProductStatus.builder()
                .statuesName(statusName)
                .build();
    }
}

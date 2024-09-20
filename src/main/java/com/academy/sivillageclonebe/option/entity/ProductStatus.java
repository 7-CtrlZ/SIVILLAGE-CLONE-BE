package com.academy.sivillageclonebe.option.entity;

import com.academy.sivillageclonebe.member.entity.Role;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatus {

    ON_SALE("판매중"),
    SOLD_OUT("품절");

    private final String productStatus;

    @JsonValue
    public String getProductStatus() {
        return productStatus;
    }

    @JsonCreator
    public static ProductStatus fromProductStatus(String value) {
        for (ProductStatus productStatus : ProductStatus.values()) {
            if (productStatus.getProductStatus().equals(value)) {
                return productStatus;
            }
        }
        throw new IllegalArgumentException("Unknown productStatus: " + value);
    }
}

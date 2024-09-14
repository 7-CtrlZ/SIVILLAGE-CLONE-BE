package com.academy.sivillageclonebe.option.vo;

import com.academy.sivillageclonebe.option.entity.ProductStatus;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SubOptionRequestVo {

    private Long mainOptionId;
    private ProductStatus productStatus;
    private String optionName;
    private Boolean isActive;
    private Boolean isDeleted;
}

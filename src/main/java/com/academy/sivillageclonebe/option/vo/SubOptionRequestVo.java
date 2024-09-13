package com.academy.sivillageclonebe.option.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SubOptionRequestVo {

    private Long mainOptionId;
    private Boolean isActive;
    private Boolean isDeleted;
}

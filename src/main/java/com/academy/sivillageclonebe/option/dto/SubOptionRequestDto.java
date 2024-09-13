package com.academy.sivillageclonebe.option.dto;

import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.entity.SubOption;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubOptionRequestDto {

    private Long mainOptionId;
    private Boolean isActive;
    private Boolean isDeleted;

    public SubOption toEntity(MainOption mainOption) {
        return SubOption.builder()
                .isActive(isActive)
                .isDeleted(isDeleted)
                .mainOption(mainOption)
                .build();
    }
}

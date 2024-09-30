package com.academy.sivillageclonebe.admin.vo;

import com.academy.sivillageclonebe.admin.dto.TopCategoryRequestDto;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TopCategoryRequestVo {

    private String topCategoryName;

    public TopCategoryRequestDto toDto() {
        return TopCategoryRequestDto.builder()
                .topCategoryName(topCategoryName)
                .build();
    }

}

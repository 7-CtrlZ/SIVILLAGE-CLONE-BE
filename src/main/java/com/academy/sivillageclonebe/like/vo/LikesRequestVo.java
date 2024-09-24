package com.academy.sivillageclonebe.like.vo;

import com.academy.sivillageclonebe.like.dto.LikesRequestDto;
import lombok.Getter;

@Getter
public class LikesRequestVo {

    private Long mainOptionId;

    public LikesRequestDto toDto() {
        return LikesRequestDto.builder()
                .mainOptionId(mainOptionId)
                .build();
    }
}

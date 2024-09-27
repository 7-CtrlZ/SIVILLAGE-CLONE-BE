package com.academy.sivillageclonebe.favorite.vo;

import com.academy.sivillageclonebe.favorite.dto.FavoriteRequestDto;
import lombok.Getter;

@Getter
public class FavoriteRequestVo {

    private String memberUuid;
    private Long mainOptionId;

    public FavoriteRequestDto toDto() {
        return FavoriteRequestDto.builder()
                .memberUuid(memberUuid)
                .mainOptionId(mainOptionId)
                .build();
    }
}

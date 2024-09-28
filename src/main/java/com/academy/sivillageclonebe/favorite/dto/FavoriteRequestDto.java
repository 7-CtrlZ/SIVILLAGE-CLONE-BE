package com.academy.sivillageclonebe.favorite.dto;

import com.academy.sivillageclonebe.favorite.entity.Favorite;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteRequestDto {

    private String memberUuid;
    private Long mainOptionId;

    public Favorite toEntity() {
        return Favorite.builder()
                .memberUuid(memberUuid)
                .mainOptionId(mainOptionId)
                .liked(true)
                .build();
    }
}

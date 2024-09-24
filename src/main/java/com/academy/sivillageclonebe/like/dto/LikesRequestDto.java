package com.academy.sivillageclonebe.like.dto;

import com.academy.sivillageclonebe.like.entity.Likes;
import com.academy.sivillageclonebe.member.entity.Member;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikesRequestDto {

    private Long mainOptionId;

    public Likes toEntity(Member member) {
        return Likes.builder()
                .memberId(member.getId())
                .mainOptionId(mainOptionId)
                .isLiked(true)
                .build();
    }
}

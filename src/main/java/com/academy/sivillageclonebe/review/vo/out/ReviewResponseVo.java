package com.academy.sivillageclonebe.review.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseVo {

    private String reviewUuid;
    private String content;
    private Integer rating;
    private String memberUuid;
    private String memberName;
    private String authorProfileImageUrl;
    private String productOption;

    @Builder
    public ReviewResponseVo(
            String reviewUuid,
            String content,
            Integer rating,
            String memberUuid,
            String memberName,
            String authorProfileImageUrl,
            String productOption
    ) {
        this.reviewUuid = reviewUuid;
        this.content = content;
        this.rating = rating;
        this.memberUuid = memberUuid;
        this.memberName = memberName;
        this.authorProfileImageUrl = authorProfileImageUrl;
        this.productOption = productOption;
    }

}

package com.academy.sivillageclonebe.review.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequestVo {

    private String content;
    private Integer rating;
    private String productOption;

    @Builder
    public ReviewRequestVo(
            String content,
            Integer rating,
            String productOption
    ) {
        this.content = content;
        this.rating = rating;
        this.productOption = productOption;
    }

}

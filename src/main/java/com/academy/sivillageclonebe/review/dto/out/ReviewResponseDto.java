package com.academy.sivillageclonebe.review.dto.out;

import com.academy.sivillageclonebe.review.entity.Review;
import com.academy.sivillageclonebe.review.vo.out.ReviewResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponseDto {

    private String reviewUuid;
    private String content;
    private Integer rating;
    private String memberUuid;
    private String memberName;
    private String productOption;

    @Builder
    public ReviewResponseDto(
            String reviewUuid,
            String content,
            Integer rating,
            String memberUuid,
            String memberName,
            String productOption
    ) {
        this.reviewUuid = reviewUuid;
        this.content = content;
        this.rating = rating;
        this.memberUuid = memberUuid;
        this.memberName = memberName;
        this.productOption = productOption;
    }

    public static ReviewResponseDto from(Review review) {
        return ReviewResponseDto.builder()
                .reviewUuid(review.getReviewUuid())
                .content(review.getContent())
                .rating(review.getRating())
                .memberUuid(review.getMemberUuid())
                .memberName(review.getMemberName())
                .productOption(review.getProductOption())
                .build();
    }

    public ReviewResponseVo toVo() {
        return ReviewResponseVo.builder()
                .reviewUuid(reviewUuid)
                .content(content)
                .rating(rating)
                .memberUuid(memberUuid)
                .memberName(memberName)
                .productOption(productOption)
                .build();
    }

}

package com.academy.sivillageclonebe.review.dto.in;

import com.academy.sivillageclonebe.review.entity.Review;
import com.academy.sivillageclonebe.review.vo.in.ReviewRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ReviewRequestDto {

    private String content;
    private Integer rating;
    private String memberUuid;
    private String memberName;
    private String productOption;
    private String reviewUuid;
    private Boolean deleted = false;

    @Builder
    public ReviewRequestDto(
            String content,
            Integer rating,
            String memberUuid,
            String memberName,
            String productOption,
            String reviewUuid,
            Boolean deleted
    ) {
        this.content = content;
        this.rating = rating;
        this.memberUuid = memberUuid;
        this.memberName = memberName;
        this.productOption = productOption;
        this.reviewUuid = reviewUuid;
        this.deleted = deleted;
    }

    public Review toEntity() {
        return Review.builder()
                .content(content)
                .rating(rating)
                .memberUuid(memberUuid)
                .memberName(memberName)
                .productOption(productOption)
                .reviewUuid(reviewUuid)
                .deleted(deleted)
                .build();
    }

    public static ReviewRequestDto of(ReviewRequestVo reviewRequestVo, String memberUuid, String memberName) {
        return ReviewRequestDto.builder()
                .content(reviewRequestVo.getContent())
                .rating(reviewRequestVo.getRating())
                .memberUuid(memberUuid)
                .memberName(memberName)
                .productOption(reviewRequestVo.getProductOption())
                .reviewUuid(UUID.randomUUID().toString())
                .deleted(false)
                .build();
    }

}

package com.academy.sivillageclonebe.review.dto.in;

import com.academy.sivillageclonebe.review.entity.MediaByReview;
import com.academy.sivillageclonebe.review.entity.Review;
import com.academy.sivillageclonebe.review.vo.in.MediaByReviewRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MediaByReviewRequestDto {

    private String reviewUuid;
    private List<Long> mediaIds;

    @Builder
    public MediaByReviewRequestDto(String reviewUuid, List<Long> mediaIds) {
        this.reviewUuid = reviewUuid;
        this.mediaIds = mediaIds;
    }

    public List<MediaByReview> toEntities(Review review) {
        return mediaIds.stream()
                .map(mediaId -> MediaByReview.builder()
                        .mediaId(mediaId)
                        .review(review)
                        .build())
                .toList();
    }

    public static MediaByReviewRequestDto of(MediaByReviewRequestVo mediaByReviewRequestVo) {
        return MediaByReviewRequestDto.builder()
                .reviewUuid(mediaByReviewRequestVo.getReviewUuid())
                .mediaIds(mediaByReviewRequestVo.getMediaIds())
                .build();
    }

}

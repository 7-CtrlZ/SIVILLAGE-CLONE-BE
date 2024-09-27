package com.academy.sivillageclonebe.review.service;


import com.academy.sivillageclonebe.review.dto.in.MediaByReviewRequestDto;
import com.academy.sivillageclonebe.review.dto.in.ReviewRequestDto;
import com.academy.sivillageclonebe.review.dto.out.ReviewResponseDto;

public interface ReviewService {

    void addReview(ReviewRequestDto reviewRequestDto, String productCode);
    ReviewResponseDto getReview(String reviewUuid);

    void addMediaByReview(MediaByReviewRequestDto mediaByReviewRequestDto);

}

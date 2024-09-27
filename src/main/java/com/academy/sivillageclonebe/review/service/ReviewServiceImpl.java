package com.academy.sivillageclonebe.review.service;


import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import com.academy.sivillageclonebe.review.dto.in.MediaByReviewRequestDto;
import com.academy.sivillageclonebe.review.dto.in.ReviewRequestDto;
import com.academy.sivillageclonebe.review.dto.out.ReviewResponseDto;
import com.academy.sivillageclonebe.review.repository.MediaByReviewRepository;
import com.academy.sivillageclonebe.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final MediaByReviewRepository mediaByReviewRepository;

    @Override
    public void addReview(ReviewRequestDto reviewRequestDto, String productCode) {
        reviewRepository.save(reviewRequestDto.toEntity());
    }

    @Override
    public ReviewResponseDto getReview(String reviewUuid) {
        return ReviewResponseDto.from(reviewRepository.findByReviewUuid(reviewUuid)
                .orElseThrow(() -> new BaseException(
                        BaseResponseStatus.NO_EXIST_COMMENT
                ))
        );
    }

    @Override
    public void addMediaByReview(MediaByReviewRequestDto mediaByReviewRequestDto) {
        mediaByReviewRepository.saveAll(mediaByReviewRequestDto.toEntities(
                reviewRepository.findByReviewUuid(mediaByReviewRequestDto.getReviewUuid())
                        .orElseThrow(() -> new BaseException(
                                BaseResponseStatus.NO_EXIST_COMMENT
                        ))
        ));
    }

}

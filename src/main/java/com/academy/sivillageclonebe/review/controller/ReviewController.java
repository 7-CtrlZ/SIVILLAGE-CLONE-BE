package com.academy.sivillageclonebe.review.controller;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.review.dto.in.MediaByReviewRequestDto;
import com.academy.sivillageclonebe.review.dto.in.ReviewRequestDto;
import com.academy.sivillageclonebe.review.service.ReviewService;
import com.academy.sivillageclonebe.review.vo.in.MediaByReviewRequestVo;
import com.academy.sivillageclonebe.review.vo.in.ReviewRequestVo;
import com.academy.sivillageclonebe.review.vo.out.ReviewResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;
    private final SecurityUtils securityUtils;

    @Operation(summary = "Add Review API", description = "Add Review API 입니다.", tags = {"Review"})
    @SecurityRequirement(name = "Bearer Auth")
    @PostMapping("/{productCode}")
    public BaseResponse<Void> addReview(
            @RequestBody ReviewRequestVo reviewRequestVo,
            @PathVariable String productCode
    ) {

        Member member = securityUtils.getAuthenticatedMember();
        reviewService.addReview(ReviewRequestDto.of(reviewRequestVo, member.getUuid(), member.getName()), productCode);
        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

    /**
     * 리뷰 조회
     * @param reviewUuid 리뷰 UUID
     * @return 리뷰 조회 응답
     */
    @Operation(summary = "Get Review API", description = "Get Review API 입니다.", tags = {"Review"})
    @GetMapping("/{reviewUuid}")
    public BaseResponse<ReviewResponseVo> getReview(
            @PathVariable String reviewUuid
    ) {
        return new BaseResponse<>(
                reviewService.getReview(reviewUuid).toVo()
        );
    }

    /**
     * 리뷰에 미디어 추가
     * @param mediaByReviewRequestVo 리뷰에 미디어 추가 요청
     * @return 리뷰에 미디어 추가 응답
     */
    @Operation(summary = "Add Media By Review API", description = "Add Media By Review API 입니다.", tags = {"Review"})
    @SecurityRequirement(name = "Bearer Auth")
    @PostMapping("/review-medias")
    public BaseResponse<Void> addMediaByReview(
            @RequestBody MediaByReviewRequestVo mediaByReviewRequestVo
    ) {
        reviewService.addMediaByReview(MediaByReviewRequestDto.of(mediaByReviewRequestVo));
        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }

}

package com.academy.sivillageclonebe.review.vo.in;

import lombok.Getter;

import java.util.List;

@Getter
public class MediaByReviewRequestVo {

    private String reviewUuid;
    private List<Long> mediaIds;

}

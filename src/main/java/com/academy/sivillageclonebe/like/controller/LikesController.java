package com.academy.sivillageclonebe.like.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.like.entity.Likes;
import com.academy.sivillageclonebe.like.service.LikesService;
import com.academy.sivillageclonebe.like.vo.LikesRequestVo;
import com.academy.sivillageclonebe.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/like")
public class LikesController {

    private final LikesService likesService;
    private final SecurityUtils securityUtils;

    @PostMapping
    public CommonResponseEntity<Void> createLikes(
            @RequestBody LikesRequestVo likesRequestvo) {
        likesService.createLikes(likesRequestvo.toDto());
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @GetMapping
    public CommonResponseEntity<List<Likes>> getLikes() {
        Member member = securityUtils.getAuthenticatedMember();
        List<Likes> likesList = likesService.getLikes(member.getId());
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                likesList);
    }

}

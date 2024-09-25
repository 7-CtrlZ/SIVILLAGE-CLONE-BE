package com.academy.sivillageclonebe.like.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.like.entity.Likes;
import com.academy.sivillageclonebe.like.service.LikesService;
import com.academy.sivillageclonebe.like.vo.LikesRequestVo;
import com.academy.sivillageclonebe.like.vo.LikesResponseVo;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.option.entity.MainOption;
import com.academy.sivillageclonebe.option.repository.MainOptionRepository;
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

    @GetMapping("{mainOptionId}")
    public CommonResponseEntity<Boolean> getLikes
        (@PathVariable Long mainOptionId){
        Member member = securityUtils.getAuthenticatedMember();
        boolean isLiked = likesService.getLikes(member.getId(), mainOptionId);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                isLiked
                );
    }

    @DeleteMapping("/{mainOptionId}")
    public CommonResponseEntity<Void> deleteLikes
            (@PathVariable Long mainOptionId) {
        Member member = securityUtils.getAuthenticatedMember();
        likesService.deleteLikes(member.getId(),mainOptionId);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

}

package com.academy.sivillageclonebe.like.service;


import com.academy.sivillageclonebe.like.dto.LikesRequestDto;

public interface LikesService {

    void createLikes(LikesRequestDto likesRequestDto);
    boolean getLikes(Long memberId, Long mainOptionId);
    void deleteLikes(Long memberId, Long mainOptionId);
}

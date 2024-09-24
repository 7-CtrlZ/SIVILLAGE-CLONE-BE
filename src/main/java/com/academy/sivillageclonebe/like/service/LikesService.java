package com.academy.sivillageclonebe.like.service;


import com.academy.sivillageclonebe.like.dto.LikesRequestDto;
import com.academy.sivillageclonebe.like.entity.Likes;

import java.util.List;

public interface LikesService {

    void createLikes(LikesRequestDto likesRequestDto);
    List<Likes> getLikes(Long memberId);
}

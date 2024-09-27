package com.academy.sivillageclonebe.media.service;


import com.academy.sivillageclonebe.media.dto.in.MediaRequestDto;
import com.academy.sivillageclonebe.media.dto.out.MediaResponseDto;

public interface MediaService {

    MediaResponseDto addMedia(MediaRequestDto mediaRequestDto);
    void deleteMedia(Long mediaId);

    MediaResponseDto getMedia(Long mediaId);

}

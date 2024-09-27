package com.academy.sivillageclonebe.media.service;


import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.common.exception.BaseException;
import com.academy.sivillageclonebe.media.dto.in.MediaRequestDto;
import com.academy.sivillageclonebe.media.dto.out.MediaResponseDto;
import com.academy.sivillageclonebe.media.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService{

    private final MediaRepository mediaRepository;

    @Override
    public MediaResponseDto addMedia(MediaRequestDto mediaRequestDto) {
        return MediaResponseDto.from(mediaRepository.save(mediaRequestDto.toEntity()));
    }

    @Override
    public void deleteMedia(Long mediaId) {
        mediaRepository.deleteById(mediaId);
    }

    @Override
    public MediaResponseDto getMedia(Long mediaId) {
        return MediaResponseDto.from(mediaRepository.findById(mediaId)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_MEDIA)));
    }
}

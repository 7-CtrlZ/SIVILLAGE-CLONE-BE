package com.academy.sivillageclonebe.media.dto.in;

import com.academy.sivillageclonebe.media.domain.Media;
import com.academy.sivillageclonebe.media.vo.in.MediaRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MediaRequestDto {

    private String mediaUrl;
    private String mediaName;
    private String mediaType;

    @Builder
    public MediaRequestDto(String mediaUrl, String mediaName, String mediaType) {
        this.mediaUrl = mediaUrl;
        this.mediaName = mediaName;
        this.mediaType = mediaType;
    }

    public Media toEntity() {
        return Media.builder()
                .mediaUrl(mediaUrl)
                .mediaName(mediaName)
                .mediaType(mediaType)
                .build();
    }

    public static MediaRequestDto of(MediaRequestVo mediaRequestVo) {
        return MediaRequestDto.builder()
                .mediaUrl(mediaRequestVo.getMediaUrl())
                .mediaName(mediaRequestVo.getMediaName())
                .mediaType(mediaRequestVo.getMediaType())
                .build();
    }

}
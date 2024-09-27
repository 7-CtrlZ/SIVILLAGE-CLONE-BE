package com.academy.sivillageclonebe.media.dto.out;

import com.academy.sivillageclonebe.media.entity.Media;
import com.academy.sivillageclonebe.media.vo.out.MediaResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MediaResponseDto {

    private Long id;
    private String mediaUrl;
    private String mediaName;
    private String mediaType;

    @Builder
    public MediaResponseDto(Long id, String mediaUrl, String mediaName, String mediaType) {
        this.id = id;
        this.mediaUrl = mediaUrl;
        this.mediaName = mediaName;
        this.mediaType = mediaType;
    }

    public static MediaResponseDto from(Media media) {
        return MediaResponseDto.builder()
                .id(media.getId())
                .mediaUrl(media.getMediaUrl())
                .mediaName(media.getMediaName())
                .mediaType(media.getMediaType())
                .build();
    }

    public MediaResponseVo toVo() {
        return MediaResponseVo.builder()
                .id(id)
                .mediaUrl(mediaUrl)
                .mediaName(mediaName)
                .mediaType(mediaType)
                .build();
    }

}

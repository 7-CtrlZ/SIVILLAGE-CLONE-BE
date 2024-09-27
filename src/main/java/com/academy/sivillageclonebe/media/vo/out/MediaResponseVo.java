package com.academy.sivillageclonebe.media.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MediaResponseVo {

    private Long id;
    private String mediaUrl;
    private String mediaName;
    private String mediaType;

    @Builder
    public MediaResponseVo(Long id, String mediaUrl, String mediaName, String mediaType) {
        this.id = id;
        this.mediaUrl = mediaUrl;
        this.mediaName = mediaName;
        this.mediaType = mediaType;
    }

}

package com.academy.sivillageclonebe.media.presentation;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.media.application.MediaService;
import com.academy.sivillageclonebe.media.dto.in.MediaRequestDto;
import com.academy.sivillageclonebe.media.vo.in.MediaRequestVo;
import com.academy.sivillageclonebe.media.vo.out.MediaResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/media")
public class MediaController {

    /**
     * 미디어 서비스
     * 1. 미디어 추가
     * 2. 미디어 조회
     * 3. 미디어 삭제
     */

    private final MediaService mediaService;

    /**
     * 미디어 추가
     * @param mediaRequestVo 미디어 추가 요청
     * @return 미디어 추가 응답
     */
    @Operation(summary = "Add Media API", description = "Add Media API 입니다.", tags = {"Media"})
    @PostMapping
    public BaseResponse<MediaResponseVo> addMedia(@RequestBody MediaRequestVo mediaRequestVo) {
        return new BaseResponse<>(
            mediaService.addMedia(MediaRequestDto.of(mediaRequestVo)).toVo()
        );
    }

    /**
     * 미디어 조회
     * @param mediaId 미디어 ID
     * @return 미디어 조회 응답
     */
    @Operation(summary = "Get Media API", description = "Get Media API 입니다.", tags = {"Media"})
    @GetMapping("/{mediaId}")
    public BaseResponse<MediaResponseVo> getMedia(@PathVariable Long mediaId) {
        return new BaseResponse<>(
                mediaService.getMedia(mediaId).toVo()
        );
    }

    /**
     * 미디어 삭제
     * @param mediaId 미디어 ID
     * @return 미디어 삭제 응답
     */
    @Operation(summary = "Delete Media API", description = "Delete Media API 입니다.", tags = {"Media"})
    @DeleteMapping("/{mediaId}")
    public BaseResponse<Void> deleteMedia(@PathVariable Long mediaId) {
        mediaService.deleteMedia(mediaId);
        return new BaseResponse<>(
                BaseResponseStatus.SUCCESS
        );
    }
}

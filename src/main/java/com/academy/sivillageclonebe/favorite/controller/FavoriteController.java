package com.academy.sivillageclonebe.favorite.controller;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.favorite.service.FavoriteService;
import com.academy.sivillageclonebe.favorite.vo.FavoriteRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Operation(summary = "찜 등록 API", description = "찜 등록 API 입니다.", tags = {"Favorite"})
    @PostMapping
    public BaseResponse<Void> addFavorite(
            @RequestBody FavoriteRequestVo favoriteRequestVo
    ) {
        favoriteService.addFavorite(favoriteRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "찜 조회 API", description = "찜 조회 API 입니다.", tags = {"Favorite"})
    @GetMapping("{mainOptionId}")
    public BaseResponse<Boolean> getFavorite
        (@PathVariable Long mainOptionId,
         @RequestParam String memberUuid){
        return new BaseResponse<>(favoriteService.getFavorite(memberUuid, mainOptionId));
    }

    @Operation(summary = "찜 삭제 API", description = "찜 삭제 API 입니다.", tags = {"Favorite"})
    @DeleteMapping("/{mainOptionId}")
    public BaseResponse<Void> deleteFavorite
            (@PathVariable Long mainOptionId) {
        favoriteService.deleteFavorite(mainOptionId);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}

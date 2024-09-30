package com.academy.sivillageclonebe.vendor.controller;

import com.academy.sivillageclonebe.common.entity.BaseResponse;
import com.academy.sivillageclonebe.common.entity.BaseResponseStatus;
import com.academy.sivillageclonebe.vendor.service.BrandService;
import com.academy.sivillageclonebe.vendor.vo.BrandRequestVo;
import com.academy.sivillageclonebe.vendor.vo.BrandResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vendor")
public class BrandController {

    private final BrandService brandService;

    @Operation(summary = "브랜드 등록 API", description = "브랜드 등록 API 입니다.", tags = {"Brand"})
    @PostMapping("/brand")
    public BaseResponse<Void> createBrand(
            @RequestBody BrandRequestVo brandRequestVo) {
        brandService.createBrand(brandRequestVo.toDto());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @Operation(summary = "브랜드 조회 API", description = "brandId를 사용한 브랜드 조회 API 입니다.", tags = {"Brand"})
    @GetMapping("brand/{brandId}")
    public BaseResponse<BrandResponseVo> getBrandById (@PathVariable Integer brandId) {
        return new BaseResponse<>(brandService.getBrandById(brandId).toVo());
    }
}

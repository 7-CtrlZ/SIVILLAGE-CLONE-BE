package com.academy.sivillageclonebe.admin.controlloer;

import com.academy.sivillageclonebe.admin.dto.MiddleCategoryRequestDto;
import com.academy.sivillageclonebe.admin.dto.TopCategoryRequestDto;
import com.academy.sivillageclonebe.admin.service.CategoryService;
import com.academy.sivillageclonebe.admin.vo.MiddleCategoryRequestVo;
import com.academy.sivillageclonebe.admin.vo.MiddleCategoryResponseVo;
import com.academy.sivillageclonebe.admin.vo.TopCategoryRequestVo;
import com.academy.sivillageclonebe.admin.vo.TopCategoryResponseVo;
import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/category")
public class CategoryController {

    public final CategoryService categoryService;

    @PostMapping("/top-category")
    public CommonResponseEntity<Void> creteTopCategory (
            @RequestBody TopCategoryRequestVo topCategoryRequestVo) {
        log.info("TopCategoryRequestVo: {}", topCategoryRequestVo);
        TopCategoryRequestDto topCategoryRequestDto = TopCategoryRequestDto.builder()
                .topCategoryName(topCategoryRequestVo.getTopCategoryName())
                .build();
        categoryService.createTopCategory(topCategoryRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @GetMapping("/top-category/{topCategoryCode}")
    public CommonResponseEntity<TopCategoryResponseVo> getTopCategoryByCategoryCode (
            @PathVariable String topCategoryCode) {
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.getTopCategoryByCategoryCode(topCategoryCode).toVo());
    }

    @PostMapping("/middle-category")
    public CommonResponseEntity<Void> creteMiddleCategory (
            @RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {
        log.info("MiddleCategoryRequestVo: {}", middleCategoryRequestVo);
        MiddleCategoryRequestDto middleCategoryRequestDto = MiddleCategoryRequestDto.builder()
                .middleCategoryName(middleCategoryRequestVo.getMiddleCategoryName())
                .topCategoryCode(middleCategoryRequestVo.getTopCategoryCode())
                .build();
        categoryService.createMiddleCategory(middleCategoryRequestDto);

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @GetMapping("/middle-category/{middleCategoryCode}")
    public CommonResponseEntity<MiddleCategoryResponseVo> getMiddleCategoryByCategoryCode (
            @PathVariable String middleCategoryCode) {
        log.info("middleCategoryCode : {}", middleCategoryCode);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                categoryService.getMiddleCategoryByCode(middleCategoryCode).toVo());
    }

}

package com.academy.sivillageclonebe.orders.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.orders.service.OrderedProductsService;
import com.academy.sivillageclonebe.orders.vo.OrderedProductsResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/orders/detail")
public class OrderedProductsController {
    private final OrderedProductsService orderedProductsService;

    @Operation(summary = "주문 상품 조회 API", description = "주문 상품 조회 API", tags = {"Orders"})
    @GetMapping("/{ordersId}")
    public CommonResponseEntity<List<OrderedProductsResponseVo>> getOrderedProductsByOrdersId(@PathVariable Long ordersId) {

        List<OrderedProductsResponseVo> orderedProductsList = orderedProductsService.getOrderedProducts(ordersId);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                orderedProductsList
        );
    }
}

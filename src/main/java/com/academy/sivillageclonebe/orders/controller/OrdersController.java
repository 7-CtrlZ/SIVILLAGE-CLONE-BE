package com.academy.sivillageclonebe.orders.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.member.vo.SignUpRequestVo;
import com.academy.sivillageclonebe.orders.service.OrdersService;
import com.academy.sivillageclonebe.orders.vo.OrdersRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Operation(summary = "SignUp API", description = "SignUp API 입니다.", tags = {"Auth"})
    @PostMapping("/create")
    public CommonResponseEntity<Void> createOrders(
            @RequestBody OrdersRequestVo ordersRequestVo) {

        ordersService.createOrder(ordersRequestVo.toDto());

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }
}

package com.academy.sivillageclonebe.orders.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.common.utills.SecurityUtils;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.orders.dto.OrdersUpdateDto;
import com.academy.sivillageclonebe.orders.entity.Orders;
import com.academy.sivillageclonebe.orders.service.OrdersService;
import com.academy.sivillageclonebe.orders.vo.OrdersRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/orders")
public class OrdersController {

    private final OrdersService ordersService;
    private final SecurityUtils securityUtils;

    @Operation(summary = "Create Order API", description = "Create Order API", tags = {"Orders"})
    @PostMapping
    public CommonResponseEntity<Void> createOrders(
            @RequestBody OrdersRequestVo ordersRequestVo) {

        ordersService.createOrder(ordersRequestVo.toDto());

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }

    @Operation(summary = "Get All Orders API", description = "Get All Orders API", tags = {"Orders"})
    @GetMapping
    public CommonResponseEntity<List<Orders>> getAllOrders() {
        Member member = securityUtils.getAuthenticatedMember();
        if (member == null) {
            throw new RuntimeException("Authenticated member not found");
        }
        List<Orders> ordersList = ordersService.getAllByMemberUuid(member.getUuid());
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                ordersList);
    }

    @Operation(summary = "Get Order by UUID API", description = "Get Order by UUID API", tags = {"Orders"})
    @GetMapping("/{uuid}")
    public CommonResponseEntity<Orders> getOrderByUuid(@PathVariable String uuid) {
        Orders order = ordersService.getOrderByUuid(uuid);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                order);
    }

    @Operation(summary = "Update Order API", description = "Update Order API", tags = {"Orders"})
    @PutMapping("/{uuid}")
    public CommonResponseEntity<Void> updateOrder(@PathVariable String uuid, @RequestBody OrdersUpdateDto ordersUpdateDto) {
        ordersService.updateOrder(uuid, ordersUpdateDto);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }

    @Operation(summary = "Delete Order API", description = "Delete Order API", tags = {"Orders"})
    @DeleteMapping("/{uuid}")
    public CommonResponseEntity<Void> deleteOrder(@PathVariable String uuid) {
        ordersService.deleteOrder(uuid);
        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null);
    }
}

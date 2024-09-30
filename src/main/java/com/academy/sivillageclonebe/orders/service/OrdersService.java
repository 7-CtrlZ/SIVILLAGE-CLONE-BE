package com.academy.sivillageclonebe.orders.service;

import com.academy.sivillageclonebe.orders.dto.OrdersRequestDto;
import com.academy.sivillageclonebe.orders.dto.OrdersStatusUpdateDto;
import com.academy.sivillageclonebe.orders.dto.OrdersUpdateDto;
import com.academy.sivillageclonebe.orders.entity.Orders;

import java.util.List;

public interface OrdersService {
    void createOrder(OrdersRequestDto ordersRequestDto);
    List<Orders> getAllByMemberUuid(String memberUuid);
    Orders getOrderByUuid(String uuid);
    void updateOrder(String uuid, OrdersUpdateDto ordersUpdateDto);
    void deleteOrder(String uuid);
    void updateOrderStatus(String uuid, OrdersStatusUpdateDto ordersStatusUpdateDto);
}

package com.academy.sivillageclonebe.orders.service;

import com.academy.sivillageclonebe.orders.vo.OrderedProductsResponseVo;

import java.util.List;

public interface OrderedProductsService  {
    List<OrderedProductsResponseVo> getOrderedProducts(Long ordersId);
}

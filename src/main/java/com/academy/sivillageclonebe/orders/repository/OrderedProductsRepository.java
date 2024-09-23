package com.academy.sivillageclonebe.orders.repository;

import com.academy.sivillageclonebe.orders.entity.OrderedProducts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Long> {

    List<OrderedProducts> findAllByOrdersId(Long ordersId);
}

package com.academy.sivillageclonebe.orders.repository;

import com.academy.sivillageclonebe.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}

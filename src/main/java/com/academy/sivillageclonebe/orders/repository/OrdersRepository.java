package com.academy.sivillageclonebe.orders.repository;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.orders.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findByUuid(String uuid);

    List<Orders> findAllByMemberUuid(String memberUuid);

    void deleteByUuid(String uuid);
}

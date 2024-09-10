package com.academy.sivillageclonebe.cart.repository;

import com.academy.sivillageclonebe.cart.entity.Cart;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByMemberIdAndBrandId(Long memberId, Integer brandId);

    List<Cart> findAllByMemberId(Long memberId);
}

package com.academy.sivillageclonebe.member.repository;

import com.academy.sivillageclonebe.member.entity.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAddressRepository extends JpaRepository<MemberAddress, Long> {
}

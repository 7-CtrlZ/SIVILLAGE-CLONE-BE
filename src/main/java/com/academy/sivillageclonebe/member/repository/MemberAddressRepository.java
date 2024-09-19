package com.academy.sivillageclonebe.member.repository;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberAddressRepository extends JpaRepository<MemberAddress, Long> {

    List<MemberAddress> findAllByMember(Member member);
    Optional<MemberAddress> findByIdAndMember(Long id, Member member);
    Optional<MemberAddress> findByMemberAndDefaultAddress(Member member, boolean defaultAddress);

}

package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.member.dto.MemberAddressDto;
import com.academy.sivillageclonebe.member.dto.MemberAddressRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;

import java.util.List;
import java.util.Map;

public interface MemberAddressService {

    void saveMemberAddress(MemberAddressRequestDto memberAddressRequestDto);

    List<MemberAddress> findAllByMember(Member member);

    MemberAddress findByIdAndMember(Long id, Member member);

    void updateMemberAddress(Long id, MemberAddressDto memberAddressDto);

    void deleteMemberAddress(Long id, Member member);

}

package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.common.jwt.JwtTokenProvider;
import com.academy.sivillageclonebe.member.dto.MemberAddressAddRequestDto;
import com.academy.sivillageclonebe.member.repository.MemberAddressRepository;
import com.academy.sivillageclonebe.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MemberAddressServiceImpl implements MemberAddressService{

    private final MemberRepository memberRepository;
    private final MemberAddressRepository memberAddressRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void saveMemberAddress(MemberAddressAddRequestDto memberAddressAddRequestDto) {
        memberAddressRepository.save(memberAddressAddRequestDto.toEntity());

    }
}

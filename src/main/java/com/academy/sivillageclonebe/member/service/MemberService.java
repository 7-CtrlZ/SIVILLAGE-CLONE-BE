package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.member.dto.SignInRequestDto;
import com.academy.sivillageclonebe.member.dto.SignInResponseDto;
import com.academy.sivillageclonebe.member.dto.SignUpRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findByEmail(String email);
}

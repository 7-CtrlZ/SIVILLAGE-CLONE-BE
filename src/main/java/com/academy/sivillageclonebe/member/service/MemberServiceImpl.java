package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.common.jwt.JwtTokenProvider;
import com.academy.sivillageclonebe.member.dto.SignInRequestDto;
import com.academy.sivillageclonebe.member.dto.SignInResponseDto;
import com.academy.sivillageclonebe.member.dto.SignUpRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.Oauth;
import com.academy.sivillageclonebe.member.repository.MemberRepository;
import com.academy.sivillageclonebe.member.repository.OauthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{


}

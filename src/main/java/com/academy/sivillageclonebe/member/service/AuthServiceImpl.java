package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.common.jwt.JwtTokenProvider;
import com.academy.sivillageclonebe.member.dto.SignInRequestDto;
import com.academy.sivillageclonebe.member.dto.SignInResponseDto;
import com.academy.sivillageclonebe.member.dto.SignUpRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
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
@RequiredArgsConstructor
@Service
@Transactional
public class AuthServiceImpl implements AuthService{

    private final MemberRepository memberRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final OauthRepository oauthRepository;

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {

        Member member = memberRepository.findByEmail(signUpRequestDto.getEmail()).orElse(null);

        if (member != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
        try {
            memberRepository.save(signUpRequestDto.toEntity(passwordEncoder));
        } catch (Exception e) {
            log.error("Error while checking username: {}", e.getMessage());
            throw new IllegalArgumentException("회원가입 중 오류가 발생했습니다.");
        }

    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInRequestDto.getEmail(),
                            signInRequestDto.getPassword()
                    )
            );
            return SignInResponseDto.builder()
                    .accessToken(createToken(authentication))
                    .name(authentication.getName())
                    .build();

        } catch (Exception e) {
            log.error("Sign in failed for user {}: {}", signInRequestDto.getEmail(), e.getMessage());
            throw new IllegalArgumentException("로그인 실패");
        }
    }

    private String createToken(Authentication authentication) {
        return jwtTokenProvider.generateAccessToken(authentication);
    }
}

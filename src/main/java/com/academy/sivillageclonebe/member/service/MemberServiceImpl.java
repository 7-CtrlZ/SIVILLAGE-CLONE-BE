package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.common.jwt.JwtTokenProvider;
import com.academy.sivillageclonebe.member.dto.SignInRequestDto;
import com.academy.sivillageclonebe.member.dto.SignInResponseDto;
import com.academy.sivillageclonebe.member.dto.SignUpRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.Oauth;
import com.academy.sivillageclonebe.member.entity.Role;
import com.academy.sivillageclonebe.member.repository.MemberRepository;
import com.academy.sivillageclonebe.member.repository.OauthRepository;
import com.academy.sivillageclonebe.member.repository.RoleRepository;
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
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final OauthRepository oauthRepository;

    @Override
    public void signUp(SignUpRequestDto signUpRequestDto) {
        Member member = memberRepository.findByUsername(signUpRequestDto.getUsername()).orElse(null);
        if (member != null) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }

        Role role = roleRepository.findById(signUpRequestDto.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        Oauth oauth = oauthRepository.findById(signUpRequestDto.getOauthId())
                .orElseThrow(() -> new RuntimeException("Oauth not found"));

        memberRepository.save(signUpRequestDto.toEntity(passwordEncoder, role, oauth));
    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto) {

        log.info("signInRequestDto : {}", signInRequestDto);
        Member member = memberRepository.findByUsername(signInRequestDto.getUsername()).orElseThrow(
                () -> new IllegalArgumentException("해당 이메일을 가진 회원이 없습니다.")
        );
        log.info("member : {}", member);
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            member.getUsername(),
                            signInRequestDto.getPassword()
                    )
            );
            return SignInResponseDto.builder()
                    .accessToken(createToken(authentication))
                    .name(member.getName())
                    .build();
        } catch (Exception e) {
            log.error("Sign in failed for user {}: {}", signInRequestDto.getUsername(), e.getMessage());
            throw new IllegalArgumentException("로그인 실패");
        }
    }

    private String createToken(Authentication authentication) {
        return jwtTokenProvider.generateAccessToken(authentication);
    }
}

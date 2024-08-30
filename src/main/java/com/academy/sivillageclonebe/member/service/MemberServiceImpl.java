package com.academy.sivillageclonebe.member.service;

import com.academy.sivillageclonebe.member.dto.MemberSignupDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void signUp(MemberSignupDto memberSignupDto) {
        log.info("memberSignUpDto : {}", memberSignupDto);
        Member member = memberSignupDto.toEntity();
        log.info("member : {}", member);
        memberRepository.save(member);
    }

    public MemberSignupDto getMemberById(Long id) {

        log.info("id : {}", id);
        Member getMember = memberRepository.findById(id).orElseThrow();
        log.info("getMember : {}", getMember);
        MemberSignupDto memberSignUpDto = MemberSignupDto.builder()
                .id(getMember.getId())
                .roleId(getMember.getRoleId())
                .oauthId(getMember.getOauthId())
                .username(getMember.getUsername())
                .password(getMember.getPassword())
                .name(getMember.getName())
                .phone(getMember.getPhone())
                .isDeleted(getMember.isDeleted())
                .createdAt(getMember.getCreatedAt())
                .updatedAt(getMember.getUpdatedAt())
                .build();
        log.info("memberSignUpDto : {}", memberSignUpDto);
        return memberSignUpDto;
    }

    @Override
    public MemberSignupDto getMemberByUsername(String username) {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("해당 이메일을 가진 회원이 없습니다.")
        );
        if (member != null) {
            MemberSignupDto memberSignUpDto = MemberSignupDto.builder()
                    .id(member.getId())
                    .roleId(member.getRoleId())
                    .oauthId(member.getOauthId())
                    .username(member.getUsername())
                    .password(member.getPassword())
                    .name(member.getName())
                    .phone(member.getPhone())
                    .isDeleted(member.isDeleted())
                    .createdAt(member.getCreatedAt())
                    .updatedAt(member.getUpdatedAt())
                    .build();
            return memberSignUpDto;
        }
        return null;
    }
}

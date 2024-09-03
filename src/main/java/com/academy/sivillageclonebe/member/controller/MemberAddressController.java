package com.academy.sivillageclonebe.member.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.service.MemberAddressService;
import com.academy.sivillageclonebe.member.service.MemberService;
import com.academy.sivillageclonebe.member.vo.MemberAddressAddRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/address")
public class MemberAddressController {

    private final MemberAddressService memberAddressService;
    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<CommonResponseEntity<Void>> saveAddress(
            @RequestBody MemberAddressAddRequestVo memberAddressAddRequestVo) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            throw new IllegalArgumentException("User is not authenticated");
        }

        String email = userDetails.getUsername();

        Member member = memberService.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        memberAddressService.saveMemberAddress(memberAddressAddRequestVo.toDto(member));

        return ResponseEntity.ok(
                new CommonResponseEntity<>(
                        HttpStatus.OK,
                        CommonResponseMessage.SUCCESS.getMessage(),
                        null
                )
        );
    }

}

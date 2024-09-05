package com.academy.sivillageclonebe.member.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.member.dto.MemberAddressDto;
import com.academy.sivillageclonebe.member.dto.MemberAddressRequestDto;
import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.MemberAddress;
import com.academy.sivillageclonebe.member.service.MemberAddressService;
import com.academy.sivillageclonebe.member.service.MemberService;
import com.academy.sivillageclonebe.member.vo.MemberAddressRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member/address")
public class MemberAddressController {

    private final MemberAddressService memberAddressService;
    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<CommonResponseEntity<Void>> saveAddress(
            @RequestBody MemberAddressRequestVo memberAddressRequestVo) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member member = getAuthenticatedMember(authentication);

        memberAddressService.saveMemberAddress(memberAddressRequestVo.toDto(member));

        return ResponseEntity.ok(
                new CommonResponseEntity<>(
                        HttpStatus.OK,
                        CommonResponseMessage.SUCCESS.getMessage(),
                        null
                )
        );
    }

    @GetMapping
    public ResponseEntity<CommonResponseEntity<List<MemberAddressDto>>> getAllAddresses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member member = getAuthenticatedMember(authentication);

        List<MemberAddressDto> addresses = memberAddressService.findAllByMember(member)
                .stream()
                .map(MemberAddressDto::toEntity)
                .toList();

        return ResponseEntity.ok(
                new CommonResponseEntity<>(
                        HttpStatus.OK,
                        CommonResponseMessage.SUCCESS.getMessage(),
                        addresses
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponseEntity<Void>> updateAddress(
            @PathVariable Long id,
            @RequestBody MemberAddressDto memberAddressDto) {
        
        memberAddressService.updateMemberAddress(id, memberAddressDto);

        return ResponseEntity.ok(
                new CommonResponseEntity<>(
                        HttpStatus.OK,
                        CommonResponseMessage.SUCCESS.getMessage(),
                        null
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponseEntity<Void>> deleteAddress(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Member member = getAuthenticatedMember(authentication);

        memberAddressService.deleteMemberAddress(id, member);

        return ResponseEntity.ok(
                new CommonResponseEntity<>(
                        HttpStatus.OK,
                        CommonResponseMessage.SUCCESS.getMessage(),
                        null
                )
        );
    }

    private Member getAuthenticatedMember(Authentication authentication) {
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            throw new IllegalArgumentException("User is not authenticated");
        }

        String email = userDetails.getUsername();
        return memberService.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}

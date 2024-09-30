package com.academy.sivillageclonebe.common.utills;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    private final MemberService memberService;

    public SecurityUtils(MemberService memberService) {
        this.memberService = memberService;
    }

    public Member getAuthenticatedMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            throw new IllegalArgumentException("User is not authenticated");
        }

        String email = userDetails.getUsername();
        return memberService.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}

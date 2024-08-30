package com.academy.sivillageclonebe.member.controller;

import com.academy.sivillageclonebe.member.dto.MemberSignupDto;
import com.academy.sivillageclonebe.member.service.MemberService;
import com.academy.sivillageclonebe.member.vo.MemberRequestVo;
import com.academy.sivillageclonebe.member.vo.MemberResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody MemberRequestVo memberRequestVo) {
        log.info("memberRequestVo : {}", memberRequestVo);
        MemberSignupDto memberSignUpDto = modelMapper.map(memberRequestVo, MemberSignupDto.class);
        memberService.signUp(memberSignUpDto);
    }



    @Operation(summary = "회원 조회", description = "ID로 특정 회원을 조회")
    @GetMapping(value = "/{username}", produces = "application/json")
    public ResponseEntity<MemberResponseVo> getMemberByUsername(@PathVariable String username) {
        MemberSignupDto getMember = memberService.getMemberByUsername(username);
        log.info("getMember : {}", getMember);
        MemberResponseVo memberResponseVo = getMember.toResponseVo();
        return ResponseEntity.ok(memberResponseVo);
    }
}

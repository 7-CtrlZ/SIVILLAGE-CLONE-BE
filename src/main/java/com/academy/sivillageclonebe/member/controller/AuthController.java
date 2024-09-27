package com.academy.sivillageclonebe.member.controller;

import com.academy.sivillageclonebe.common.entity.CommonResponseEntity;
import com.academy.sivillageclonebe.common.entity.CommonResponseMessage;
import com.academy.sivillageclonebe.member.service.AuthService;
import com.academy.sivillageclonebe.member.vo.SignInRequestVo;
import com.academy.sivillageclonebe.member.vo.SignInResponseVo;
import com.academy.sivillageclonebe.member.vo.SignUpRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "로그인 API", description = "로그인 API 입니다.", tags = {"Auth"})
    @PostMapping("/sign-in")
    public CommonResponseEntity<SignInResponseVo> signIn(
            @RequestBody SignInRequestVo signInRequestVo) {

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                authService.signIn(signInRequestVo.toDto()).toVo()
        );


    }

    @Operation(summary = "회원가입 API", description = "회원가입 API 입니다.", tags = {"Auth"})
    @PostMapping("/sign-up")
    public CommonResponseEntity<Void> signUp(
            @RequestBody SignUpRequestVo signUpRequestVo) {

        authService.signUp(signUpRequestVo.toDto());

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                CommonResponseMessage.SUCCESS.getMessage(),
                null
        );
    }
}

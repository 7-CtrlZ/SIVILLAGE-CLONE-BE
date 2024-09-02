package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.Oauth;
import com.academy.sivillageclonebe.member.entity.Role;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SignUpRequestDto {

    private Long id;
    private Role role;
    private String email;
    private String password;
    private String name;
    private String phone;
    private boolean isDeleted;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .id(id)
                .role(role)
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .phone(phone)
                .isDeleted(false)
                .build();
    }

}

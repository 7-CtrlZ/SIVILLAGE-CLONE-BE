package com.academy.sivillageclonebe.member.dto;

import com.academy.sivillageclonebe.member.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SignUpRequestDto {

    private Long id;
    private Long roleId;
    private Long oauthId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private boolean isDeleted;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .id(id)
                .roleId(roleId)
                .oauthId(oauthId)
                .username(username)
                .password(passwordEncoder.encode(password))
                .name(name)
                .phone(phone)
                .isDeleted(false)
                .build();
    }

}

package com.academy.sivillageclonebe.member.vo;

import com.academy.sivillageclonebe.member.entity.Role;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseVo {

    private Long id;
    private Role role;
    private String email;
    private String name;
    private String phone;
    private boolean isDeleted;

}

package com.academy.sivillageclonebe.member.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    MEMBER("멤버"),
    SELLER("셀러"),
    ADMIN("관리자");

    private final String role;

    @JsonValue
    public String getRole() {
        return role;
    }

    @JsonCreator
    public static Role fromRole(String value) {
        for (Role role : Role.values()) {
            if (role.getRole().equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }

}

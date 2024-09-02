package com.academy.sivillageclonebe.member.repository;

import com.academy.sivillageclonebe.member.entity.Member;
import com.academy.sivillageclonebe.member.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

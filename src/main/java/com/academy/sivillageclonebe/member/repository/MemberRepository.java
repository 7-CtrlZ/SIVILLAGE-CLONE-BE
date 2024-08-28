package com.academy.sivillageclonebe.member.repository;

import com.academy.sivillageclonebe.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

package com.back.p64260806.domain.member.repository;

import com.back.p64260806.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

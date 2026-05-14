package com.ingan121.shop.member.repository;

import com.ingan121.shop.member.Member;

import java.util.List;

public interface MemberRepository {
    Member findById(Long id);
    List<Member> findAll();
    Member findByLoginId(String loginId);
    void save(Member member);
    void deleteById(Long id);
}

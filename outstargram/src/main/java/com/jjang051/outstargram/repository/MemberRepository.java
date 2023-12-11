package com.jjang051.outstargram.repository;

import com.jjang051.outstargram.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
    // crud
    Optional<Member> findByUserId(String userId);
}

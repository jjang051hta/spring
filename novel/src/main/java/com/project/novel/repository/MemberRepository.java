package com.project.novel.repository;

import com.project.novel.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member,Integer> {
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByPassword(String password);


    /*@Query("SELECT COUNT(*) FROM Member m WHERE m.userId = :userId")
    int checkDuplicatedId(@Param("userId") String userId);

    @Query("SELECT COUNT(*) FROM Member m WHERE m.email = :email")
    int checkDuplicatedEmail(@Param("email") String email);*/
}

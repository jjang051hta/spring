package com.project.novel.entity;

import com.project.novel.constant.Grade;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class) // 자동으로 날짜를 생성
@Table(name="member_table")
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "memberId")
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String userName;

    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(length = 2)
    private Integer age;

    private String phoneNumber;

    private Integer coin;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Grade role;
    // 등급에 따른 role 부여하는 컬럼

    @CreatedDate
    private LocalDateTime createdAt;
    // 회원 등록 날짜
    @LastModifiedDate
    private LocalDateTime updatedAt;
    // 회원정보수정 날짜
}

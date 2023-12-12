package com.jjang051.outstargram.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jjang051.outstargram.constant.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@Table(name="table_member")
@EntityListeners(AuditingEntityListener.class)
public class Member {
    // join되게 해보기....
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="member_id")
    private int id;

    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    @JsonIgnore
    private String password;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String mbti;

    private String description;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    private String profileImageUrl;

//    private String thumbProfileImageUrl;
//
//    private String renamedProfileImageUrl;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;
}




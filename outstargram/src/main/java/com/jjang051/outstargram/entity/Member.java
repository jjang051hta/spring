package com.jjang051.outstargram.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@Table(name="table_member")
public class Member {
    // join되게 해보기....
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="member_id")
    private int id;

    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String password;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

}

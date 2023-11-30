package com.jjang051.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member02 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 30)
    private String userId;
    @Column(length = 100)
    private String nickName;
    @Column(length = 100)
    private  String email;

    private Integer age;
}

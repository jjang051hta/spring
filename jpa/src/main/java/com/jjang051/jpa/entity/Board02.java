package com.jjang051.jpa.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

@Getter
@Setter
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
//@Table(name = "myBoard")
public class Board02 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="boardId")
    private Integer id;

    //@Column(name = "mySubject")
    private String subject;

    @Column(length = 2000)
    private String content;
}

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
@Table(name = "aaa")
public class Board02 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boad02_seq_gen")
    @SequenceGenerator(name="boad02_seq_gen",sequenceName = "boad02_seq", initialValue = 1, allocationSize = 1)
    @Column(name="boardId")
    private Integer id;

    //@Column(name = "mySubject")
    private String subject;

    @Column(length = 2000)
    private String content;
}

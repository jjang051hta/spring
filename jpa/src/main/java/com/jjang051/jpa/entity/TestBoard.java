package com.jjang051.jpa.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class TestBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name="boardId")
    private Integer id;

    //@Column(name = "mySubject")
    private String subject;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "board02", cascade = CascadeType.REMOVE)
    private List<Comment02> commentList;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member02 writer;

    @Builder
    public TestBoard(String subject, LocalDateTime createDate, List<Comment02> commentList, Member02 writer) {
        this.subject = subject;
        this.createDate = createDate;
        this.commentList = commentList;
        this.writer = writer;
    }
}

package com.jjang051.outstargram.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class Subscribe {
    // join되게 해보기....
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    @ManyToOne
    @JoinColumn(name="fromMemberId")
    private Member fromMember;

    @ManyToOne
    @JoinColumn(name="toMemberId")
    private Member toMember;

    @CreatedDate
    private LocalDateTime createDate;
}

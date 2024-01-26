package com.jjang051.outstargram.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@EntityListeners(AuditingEntityListener.class)
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;



    @ManyToOne
    @JoinColumn(name = "imageId")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "memberId")
    @JsonIgnoreProperties({"imageList"})
    private Member member;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

}

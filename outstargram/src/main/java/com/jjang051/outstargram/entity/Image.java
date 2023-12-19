package com.jjang051.outstargram.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String caption;
    private String imgUrl;

    @JoinColumn(name="member_id")
    @ManyToOne()
    @JsonIgnoreProperties({"imageList"})
    private Member member;

    @JsonIgnoreProperties({"image"})
    @OneToMany(mappedBy = "image")
    private List<Likes> likes;

    @OrderBy("createDate DESC, id ASC")
    @OneToMany(mappedBy = "image")
    @JsonIgnoreProperties({"image"})
    private List<Comments> commentsList;



    // 152번 이미지에 1번 유저가 좋아요를 눌렀는지 안눌렀는지...
    // entity에 있는 속성은 column을 만든다 이때 컬럼을 만들지 않을려면....
    @Transient
    private boolean likeState;

    @Transient
    private int likeTotal;


    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;
}

package com.jjang051.outstargram.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class CommentDto {
    private String content;
    private int imageId;
}

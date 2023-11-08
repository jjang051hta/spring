package com.jjang051.board.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    @NotEmpty(message = "이름은 필수입력사항입니다.")
    private String name;
    @NotEmpty(message = "제목은 필수입력사항입니다.")
    @Size(min=5,max=100, message = "최소5글자 이상 최대 100자까지 가능합니다.")
    private String title;
    @NotEmpty
    private String content;

    private String regdate;
}

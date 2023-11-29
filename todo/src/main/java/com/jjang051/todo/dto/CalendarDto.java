package com.jjang051.todo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalendarDto {

    private String id;
    private String title;
    private String start;  // 시작일
    private String end;    // 마무리
    private String backgroundColor;
    private String textColor;
    private String borderColor;

}

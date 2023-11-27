package com.jjang051.board.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalendarDto {
    private String title;
    private String start;
    private String end;

}

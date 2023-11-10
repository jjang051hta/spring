package com.jjang051.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {
    private int currentPage;
    private int pageSize; // 세로....
    public Criteria() {
        this.currentPage = 1;
        this.pageSize = 10;
    }
    public int getStartPage() {
        return (currentPage - 1) * pageSize+1;
    }
    public int getEndPage() {
        return currentPage*pageSize;
    }
}

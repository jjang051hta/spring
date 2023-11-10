package com.jjang051.board.utils;

import com.jjang051.board.dto.Criteria;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Component
public class PageMaker {
    // 이 클래스는 아래쪽 pagination에 관련된 것
    private Criteria criteria;  // 기준 체조 대형으로 벌려 하나 둘 셋
    private int total;          // 전체 갯수
    private int startPage;      // 시작 패이지
    private int endPage;        // 마지막 페이지
    private int pageBlock = 10;      //    1/2/3/4/5
    private boolean isPrev;     // 이전 페이지
    private boolean isNext;     //다음 페이지

    //   1/2/3/4/5
    //   6/7/8/9/10

    // 전체 페이지 갯수를 정하는 순간 페이지 만들기....
    public void setTotal(int total) {
        this.total = total;
        makePage();
    }
    private void makePage() {
        //  1~10
        endPage = (int) Math.ceil( (criteria.getCurrentPage() / (double) pageBlock)  ) * pageBlock;
        startPage = (endPage - pageBlock) + 1;

    }
}

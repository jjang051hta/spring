package com.jjang051.outstargram.dto;

import com.jjang051.outstargram.entity.Member;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberProfileDto {
    private boolean pageOwner;
    private Member member;
    private int subscribeCount;
    private boolean subscribeState;
    private int imageTotal;
}

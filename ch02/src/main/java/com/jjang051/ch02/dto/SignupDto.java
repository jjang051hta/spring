package com.jjang051.ch02.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupDto {
    private String name;
    private String userId;

    private String email;
    private String password;

    private String regDate;
}

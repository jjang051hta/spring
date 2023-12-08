package com.jjang051.outstargram.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {
    @NotBlank
    @Size(min = 4, max=20)
    private String userId;

    @NotBlank
    @Size(min = 4, max=20)
    //@Pattern()
    private String password;

    @Email
    private String email;

    private String name;


}

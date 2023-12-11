package com.jjang051.outstargram.dto;

import com.jjang051.outstargram.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UpdateMemberDto {

    private int id;

    private String userId;
    private String password;

    private String name;

    private String email;

    private String mbti;

    private String description;

    private String phone;

}

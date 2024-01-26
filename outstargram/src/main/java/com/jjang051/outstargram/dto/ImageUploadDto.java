package com.jjang051.outstargram.dto;

import com.jjang051.outstargram.entity.Image;
import com.jjang051.outstargram.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class ImageUploadDto {
    private MultipartFile file;
    private String caption;

    public Image toEntity(String imgUrl, Member member) {
        return Image.builder()
                .caption(caption)
                .imgUrl(imgUrl)
                .member(member)
                .build();
    }
    // save entity
}

package com.jjang051.gallery.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GalleryDto {
    private int id;
    private String title;
    private String description;
    private String link;

    private String bg;

    private MultipartFile file;

    private String original;
    private String renamed;


}

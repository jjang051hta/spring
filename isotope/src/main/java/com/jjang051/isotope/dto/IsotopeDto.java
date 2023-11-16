package com.jjang051.isotope.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class IsotopeDto {
    private int id;

    @NotBlank(message="제목은 필수 입력사항입니다.")
    private String title;

    @NotBlank(message="내용은 필수 입력사항입니다.")
    @Size(min=10, max=3000, message = "최소 5글자 이상 쓰셔야 합니다")
    private String description;

    private MultipartFile file;
    //regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자로 포함해서 6~12자리 이내로 입력해주세요."
    /*@DecimalMax(value = "5.0", message = "5점보다 클 수 없습니다.")
    @DecimalMin(value = "0.0", message = "0점보다 작을 수 없습니다.")*/
    @Range(min = 0, max = 10, message = "0~5점 사이 가능합니다.")
    private Double point;

    private String category;

    private String regdate;

    private String original;




    private String renamed;

}

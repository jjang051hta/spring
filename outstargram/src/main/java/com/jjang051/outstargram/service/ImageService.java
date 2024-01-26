package com.jjang051.outstargram.service;

import com.jjang051.outstargram.dto.CustomUserDetails;
import com.jjang051.outstargram.dto.ImageUploadDto;
import com.jjang051.outstargram.entity.Image;
import com.jjang051.outstargram.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {
    private final ImageRepository imageRepository;
    @Value("${file.path}")
    private String uploadFolder;

    //login한 사람이 이미지 업로드

    public void upload(ImageUploadDto imageUploadDto, CustomUserDetails customUserDetails) {
        String originalFileName = imageUploadDto.getFile().getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid+"_"+originalFileName;
        Path imageFilePath = Paths.get(uploadFolder+imageFileName);

        try {
            Files.write(imageFilePath,imageUploadDto.getFile().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image image = imageUploadDto.toEntity(imageFileName,customUserDetails.getLoggedMember());
        imageRepository.save(image);
    }

    public Page<Image> loadStory(int customDetailsId, Pageable pageable) {
        Page<Image> images = imageRepository.loadStory(customDetailsId,pageable);
        images.forEach((image)->{
            image.setLikeTotal(image.getLikes().size());  // arrayList
            image.getLikes().forEach((like)->{
                // 152번 이미지 user 1,2,3
                if(like.getMember().getId()==customDetailsId) {
                    image.setLikeState(true);
                }
            });
        });
        return images;
    }

    public Page<Image> popular(Pageable pageable) {
        return imageRepository.popular(pageable);
    }

    public Image loadDetail(int id) {
        Image imageInfo = imageRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("없는 페이지 이빈다.")
        );
        imageInfo.setLikeTotal(imageInfo.getLikes().size());
        return imageInfo;
    }
}

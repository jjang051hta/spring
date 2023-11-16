package com.jjang051.gallery.service;

import com.jjang051.gallery.dao.GalleryDao;
import com.jjang051.gallery.dto.GalleryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
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
public class GalleryService {


    @Value("${file.path}")
    private String uploadFoler;

//    @Value("${member.name}")
//    private String memberName;
//
//    @Value("${member.age}")
//    private String memberAge;

    private final GalleryDao galleryDao;

    public List<GalleryDto> getAllList() {
        List<GalleryDto> galleryList = galleryDao.getAllList();
        return galleryList;
    }
    public int insertGallery(GalleryDto galleryDto) {



        UUID uuid = UUID.randomUUID();

        String originalFile = galleryDto.getFile().getOriginalFilename();
        String renamedFile= uuid+"_"+originalFile;


        Path imgFilePath = Paths.get(uploadFoler+renamedFile);

        galleryDto.setOriginal(originalFile);
        galleryDto.setRenamed(renamedFile);


        try {
            Files.write(imgFilePath,galleryDto.getFile().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int result = galleryDao.insertGallery(galleryDto);
        return result;
    }
}

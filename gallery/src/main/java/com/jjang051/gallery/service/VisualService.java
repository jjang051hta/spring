package com.jjang051.gallery.service;

import com.jjang051.gallery.dao.VisualDao;
import com.jjang051.gallery.dto.VisualDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VisualService {
    // 업로드할 폴더
    @Value("${file.path}")
    private String uploadFolder;

    private final VisualDao visualDao;

    public List<VisualDto> gelAllVisualList() {
        List<VisualDto> visualList = visualDao.getAllVisualList();
        return visualList;
    }
    public int insertVisual(VisualDto visualDto) {
        // 오늘날짜 갑지고 이름바꾸기...
        String originalFile = visualDto.getFile().getOriginalFilename(); // 이게 진짜 파일 이름...
        String renamedFile = null;
        String folder =  null;
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        folder = simpleDateFormat.format(now);
        File dir = new File(uploadFolder+File.separator+folder);
        if(!dir.exists()) dir.mkdirs();

        // file이름 분리하고 확장자 분리
        String fileName = originalFile.substring(0,originalFile.lastIndexOf("."));
        String ext = originalFile.substring(originalFile.lastIndexOf("."));
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strNow = simpleDateFormat.format(now);
        log.info("strNow==={}",strNow);
        renamedFile = fileName+"_"+strNow+ext;
        Path imgFilePath = Paths.get(dir+File.separator+renamedFile);
        visualDto.setOriginal(originalFile);
        visualDto.setRenamed(renamedFile);
        try {
            Files.write(imgFilePath,visualDto.getFile().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int result = visualDao.insertVisual(visualDto);
        return result;
    }
}










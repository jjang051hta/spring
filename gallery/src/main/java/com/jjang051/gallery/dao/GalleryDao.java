package com.jjang051.gallery.dao;

import com.jjang051.gallery.dto.GalleryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryDao {
    int insertGallery(GalleryDto galleryDto);
    List<GalleryDto> getAllList();

}

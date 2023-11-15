package com.jjang051.gallery.dao;

import com.jjang051.gallery.dto.GalleryDto;
import com.jjang051.gallery.dto.VisualDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisualDao {
    int insertVisual(VisualDto visualDto);
    List<VisualDto> getAllVisualList();

}

package com.jjang051.isotope.dao;

import com.jjang051.isotope.dto.IsotopeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface IsotopeDao {
    int insertIsotope(IsotopeDto isotopeDto);
    List<IsotopeDto> getAllList();
}

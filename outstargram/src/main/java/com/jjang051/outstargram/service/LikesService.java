package com.jjang051.outstargram.service;

import com.jjang051.outstargram.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikesService {
    private final LikesRepository likesRepository;

    @Transactional
    public int like(int imageId, int customDetailsId){
        int result = likesRepository.like(imageId, customDetailsId);
        log.info("result==={}",result);
        return result;
    }

    @Transactional
    public int hate(int imageId, int customDetailsId){
        int result = likesRepository.hate(imageId, customDetailsId);
        log.info("result==={}",result);
        return result;
    }
}

package com.jjang051.outstargram.service;

import com.jjang051.outstargram.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;

    @Transactional
    public int like(int imageId, int customDetailsId){
        int result = likesRepository.like(imageId, customDetailsId);
        return result;
    }
}

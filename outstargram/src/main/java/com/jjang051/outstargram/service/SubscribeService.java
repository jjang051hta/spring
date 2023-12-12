package com.jjang051.outstargram.service;

import com.jjang051.outstargram.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;
    public void subscribe(int fromMemberId, int toMemberId) {
        subscribeRepository.subscribe(fromMemberId,toMemberId);
    }
}

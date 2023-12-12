package com.jjang051.outstargram.service;

import com.jjang051.outstargram.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;
    @Transactional
    public void subscribe(int fromMemberId, int toMemberId) {
        subscribeRepository.subscribe(fromMemberId,toMemberId);
    }

    @Transactional
    public int subscribeCount(int memberId) {
        return subscribeRepository.subscribeCount(memberId);   //count
    }


    @Transactional
    public void unSubscribe(int customerDetailsId, int urlId) {
        subscribeRepository.subscribe(customerDetailsId,urlId);
    }
}

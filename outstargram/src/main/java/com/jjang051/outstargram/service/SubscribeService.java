package com.jjang051.outstargram.service;

import com.jjang051.outstargram.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;


    @Transactional
    public int subscribeCount(int memberId) {
        return subscribeRepository.subscribeCount(memberId);   //count
    }


    @Transactional
    public void subscribe(int customerDetailsId, int urlId) {
        log.info("subscribe===");
        subscribeRepository.subscribe(customerDetailsId,urlId);
    }
    @Transactional
    public void unSubscribe(int customerDetailsId, int urlId) {
        log.info("unSubscribe===");
        subscribeRepository.unSubscribe(customerDetailsId,urlId);
    }
}

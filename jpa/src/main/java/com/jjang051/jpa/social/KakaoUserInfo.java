package com.jjang051.jpa.social;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class KakaoUserInfo implements SocialUserInfo {
    private final Map<String , Object> attibutes;
    @Override
    public String getProvider() {
        return "kakao";
    }
    @Override
    public String getProviderId() {
        return getProvider()+"_"+(String)attibutes.get("sub");
    }
    @Override
    public String getEmail() {
        return (String)attibutes.get("email");
    }
    @Override
    public String getName() {
        return (String)attibutes.get("nickname");
    }
}

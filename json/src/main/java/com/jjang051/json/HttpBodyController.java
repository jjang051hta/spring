package com.jjang051.json;

import com.jjang051.json.dto.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class HttpBodyController {

    // get/post/put/delete

    @PostMapping("/body01")
    public String xwwwformurlencoded(String name) {
        log.info("클라이언트에서 넘어온 name==={}",name);
        return "httpBody 전송방식중 하나인 key value 넘어옴";
    }

    @PostMapping("/body02")
    public String textplain(@RequestBody String data) {
        log.info("클라이언트에서 넘어온 data==={}",data);

        return "textplain";
    }

    @PostMapping("/body03")
    public String applicationjson(@RequestBody String data) {
        log.info("클라이언트에서 넘어온 data==={}",data);
        return "applcation/json";
    }

    @PostMapping("/body04")
    public Map<String,?> applicationjsonToObject(@RequestBody Member member) {
        log.info("클라이언트에서 넘어온 data==={}",member);
        log.info("member==={}",member);
        log.info("name==={}",member.getName());
        log.info("age==={}",member.getAge());
        Map<String,Member> map = new HashMap<>();

        map.put("member",member);
        return map;
    }
    @PostMapping("/body05")
    public void applicationjsonToObject(@RequestBody Map<String,?> map) {
        log.info("클라이언트에서 넘어온 data==={}",map);
        log.info("===={}",map.get("name"));

    }

}

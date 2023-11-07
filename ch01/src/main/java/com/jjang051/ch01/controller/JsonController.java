package com.jjang051.ch01.controller;

import com.jjang051.ch01.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller  ResponseBody
@RestController
public class JsonController {
    //MessageConveter 가 스프링 내부에서 동작
    @GetMapping("/response/json")
    public Person responseJson() {
        Person person = Person
        .builder()
                .tel("010-1111-2222")
                .age(10)
                .name("장동건")
                .build();
        return person;
    }
}

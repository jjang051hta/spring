package com.jjang051.jpa.repository;

import com.jjang051.jpa.entity.Member02;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("1+2는 3이다")
    @Test
    public void test() {
        int a = 1;
        int b = 2;
        int sum = 3;
        Assertions.assertEquals(sum,a+b);
    }

    public void joinMember() {
        for(int i=0;i<10;i++) {
            Member02 dbInsertMember = Member02.builder()
                    .userId("jjang"+i)
                    .email("jjang"+i+"@hanmail.net")
                    .nickName("길동"+i)
                    .age(10+i)
                    .build();
            memberRepository.save(dbInsertMember);
        }
    }

    @Test
    @DisplayName("이름으로 조회")
    public void findByNickNameTest() {
        joinMember();
        List<Member02> memberList = memberRepository.findByNickName("길동2");
        Assertions.assertEquals(1,memberList.size());
//        for(Member02 item: memberList) {
//            System.out.println(item.toString());
//        }
    }
}






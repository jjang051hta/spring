package com.jjang051.board.service;

import com.jjang051.board.dto.MailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    public void sendMail(MailDto mailDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDto.getReceiver());
        simpleMailMessage.setFrom("jjang051hta@naver.com");
        simpleMailMessage.setSubject(mailDto.getTitle());
        simpleMailMessage.setText(mailDto.getContent());
        javaMailSender.send(simpleMailMessage);

    }

    private int randomNumber;
    public void createRandomNumber() {
        randomNumber = (int)(Math.random()*90000)+10000;
        log.info("randomNumber==={}",randomNumber);
    }

    public MimeMessage createMail(String mail) {
        //렌덤 숫자 생성
        createRandomNumber();
        MimeMessage message =  javaMailSender.createMimeMessage();
        try {
            message.setFrom("jjang051hta@naver.com");  // 보내는 사람
            message.setRecipients(MimeMessage.RecipientType.TO,mail);  // 받는 사람
            message.setSubject("이메일 검증");
            String content = "<h2>요청하신 인증번호입니다.</h2>";
            content+="<h1 style='font-size:100px; color:#f00;'>"+randomNumber+"</h1>";
            message.setText(content,"UTF-8","html");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
    public int sendMailAuthEmail(String mail) {
        MimeMessage message = createMail(mail);
        javaMailSender.send(message);
        return randomNumber;
    }
}

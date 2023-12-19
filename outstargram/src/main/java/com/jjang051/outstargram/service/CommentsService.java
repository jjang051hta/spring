package com.jjang051.outstargram.service;

import com.jjang051.outstargram.entity.Comments;
import com.jjang051.outstargram.entity.Image;
import com.jjang051.outstargram.entity.Member;
import com.jjang051.outstargram.repository.CommentsRepository;
import com.jjang051.outstargram.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Comments saveComment(String content, int imageId, int customDetailsId) {
        Image image = Image.builder()
                .id(imageId)
                .build();
        Member memberEntity = memberRepository.findById(customDetailsId).orElseThrow(()->{
            throw new UsernameNotFoundException("없는 유저입니다.");
        });
//        Optional<Member> optionalMember = memberRepository.findById(customDetailsId);
//        if(!optionalMember.isEmpty()) {
//            memberEntity = optionalMember.get();
//        }
        Comments comments = Comments.builder()
                .content(content)
                .image(image)
                .member(memberEntity)
                .build();
        return commentsRepository.save(comments);
    }

    @Transactional
    public void deleteComment(int id) {
        commentsRepository.deleteById(id);
    }
}

package com.jjang051.outstargram.service;

import com.jjang051.outstargram.constant.Role;
import com.jjang051.outstargram.dto.JoinDto;
import com.jjang051.outstargram.dto.MemberProfileDto;
import com.jjang051.outstargram.dto.UpdateMemberDto;
import com.jjang051.outstargram.entity.Member;
import com.jjang051.outstargram.repository.MemberRepository;
import com.jjang051.outstargram.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final SubscribeRepository subscribeRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Value("${file.path}")
    private  String uploadFoler;

    @Transactional
    public Member join(JoinDto joinDto) {
        Member dbJoinMEmber = Member.builder()
                .userId(joinDto.getUserId())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .role(Role.ROLE_USER)
                .email(joinDto.getEmail())
                .name(joinDto.getName())
                .build();
        return memberRepository.save(dbJoinMEmber);
    }

    @Transactional
    public Member updateMember(int id,UpdateMemberDto updateMemberDto) {
        log.info("id==={}",id);
        log.info("updateMemberDto==={}",updateMemberDto.toString());

        Optional<Member> findMember =  memberRepository.findById(id);
        if(findMember.isPresent()) {
            Member member = findMember.get();
            member.setMbti(updateMemberDto.getMbti());
            member.setEmail(updateMemberDto.getEmail());
            member.setPhone(updateMemberDto.getPhone());
            member.setDescription(updateMemberDto.getDescription());
            member.setName(updateMemberDto.getName());
            //memberRepository.save(member);
            return member;
        } else {
            throw new UsernameNotFoundException("서버 오류입니다.");
        }
    }

    @Transactional
    public Member changeProfile(int id, MultipartFile profileImageUrl) {
        log.info("id===={}",id);
        String originalFileName = profileImageUrl.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String imageFileName = uuid+"_"+profileImageUrl.getOriginalFilename();
        String thumbnailFileName = "thumb_"+imageFileName;

        Path imageFilePath = Paths.get(uploadFoler+imageFileName);
        File originalFile = new File(uploadFoler+imageFileName);
        try {
            Files.write(imageFilePath,profileImageUrl.getBytes());
            Thumbnailator.createThumbnail(originalFile,
                                          new File(uploadFoler+thumbnailFileName),150,150);
            originalFile.delete();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Optional<Member> optionalMember = memberRepository.findById(id);  // member
        if(optionalMember.isPresent()) {
            optionalMember.get().setProfileImageUrl(thumbnailFileName);
            return optionalMember.get();
        } else {
            throw new UsernameNotFoundException("서버 오류입니다.");
        }
    }

    public MemberProfileDto getProfile(int id,int customerDetailsId) {
        MemberProfileDto memberProfileDto = new MemberProfileDto();
        Member  memberInfo =
                memberRepository.findById(id).orElseThrow(
                        ()-> new UsernameNotFoundException("없는 사용자 입니다.")
                );
        int subscribeCount = subscribeRepository.subscribeCount(id);
        int subscribeState = subscribeRepository.subscribeState(customerDetailsId,id);
        log.info("subscribeState==={}",subscribeState);
        log.info("id==={}===customerDetailsId==={}",id,customerDetailsId);

        memberProfileDto.setPageOwner(id==customerDetailsId);
        memberProfileDto.setMember(memberInfo);
        memberProfileDto.setSubscribeCount(subscribeCount);
        memberProfileDto.setSubscribeState(subscribeState >= 1);
        memberProfileDto.setImageTotal(memberInfo.getImageList().size());


        log.info("memberInfo.getImageList().size()===={}",memberInfo.getImageList().size());
        memberInfo.getImageList().forEach((image)->{
            log.info("image.getLikes().size()==={}",image.getLikes().size());
            image.setLikeTotal(image.getLikes().size());
        });
        //memberProfileDto.setLikeTotal();
        return memberProfileDto;
    }
}

package com.jjang051.outstargram.repository;

import com.jjang051.outstargram.entity.Subscribe;
import com.jjang051.outstargram.service.SubscribeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

    @Modifying
    @Query(
            value="INSERT INTO SUBSCRIBE " +
                    "(id,fromMemberId,toMemberId, createdate) VALUES (SUBSCRIBE_SEQ.nextval,:fromMemberId,:toMemebrId, sysdate)"
            ,nativeQuery = true)
    void subscribe(@Param("fromMemberId") int fromMemberId, @Param("toMemebrId") int toMemebrId);

    @Query(value="SELECT COUNT(*) FROM SUBSCRIBE WHERE fromMemberId = :memberId",nativeQuery = true)
    int subscribeCount(@Param("memberId") int memberId);



}

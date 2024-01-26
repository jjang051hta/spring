package com.jjang051.outstargram.repository;

import com.jjang051.outstargram.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes,Integer> {


    @Modifying
    @Query(value="INSERT INTO LIKES(id,imageId,memberId,createDate) " +
            "VALUES(LIKES_SEQ.nextval,:imageId,:customDetailsId, sysdate)", nativeQuery=true)
    int like(@Param("imageId") int imageId,@Param("customDetailsId") int customDetailsId);

    @Modifying
    @Query(value="DELETE FROM LIKES WHERE imageId = :imageId AND memberId = :customDetailsId", nativeQuery=true)
    int hate(@Param("imageId") int imageId,@Param("customDetailsId") int customDetailsId);
}

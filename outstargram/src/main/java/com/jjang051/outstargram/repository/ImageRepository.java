package com.jjang051.outstargram.repository;

import com.jjang051.outstargram.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {

    @Query(value="SELECT * FROM IMAGE WHERE MEMBER_ID IN " +
            "(SELECT TOMEMBERID FROM SUBSCRIBE WHERE FROMMEMBERID = :customUserdetailsId)",
            nativeQuery = true)
    Page<Image> loadStory(@Param("customUserdetailsId") int customUserdetailsId, Pageable pageable);

    @Query(value="SELECT * FROM IMAGE i " +
            "INNER JOIN (SELECT imageId, count(imageId) AS likeCount " +
            "FROM likes " +
            "GROUP BY imageId) c " +
            "ON i.id = c.imageId " +
            "ORDER BY likeCount DESC", nativeQuery = true)
    Page<Image> popular(Pageable pageable);

}

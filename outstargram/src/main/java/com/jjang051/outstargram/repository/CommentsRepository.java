package com.jjang051.outstargram.repository;

import com.jjang051.outstargram.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    // @Query를 통한 crud의 경우 return type int
    // save를 통한 입력은 entity
}

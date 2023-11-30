package com.jjang051.jpa.repository;

import com.jjang051.jpa.entity.Board02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository  extends JpaRepository<Board02,Integer> {
    // crud
    // insert == save
    // select == find
    // update == save
    // delete == delete

}

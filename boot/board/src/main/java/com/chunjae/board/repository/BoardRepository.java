package com.chunjae.board.repository;

import com.chunjae.board.domain.UserBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<UserBoard,Long> {
    @Override
    List<UserBoard> findAll();

    @Override
    Optional<UserBoard> findById(Long aLong);
}

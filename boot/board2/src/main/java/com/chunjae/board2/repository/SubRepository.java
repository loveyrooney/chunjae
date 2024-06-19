package com.chunjae.board2.repository;

import com.chunjae.board2.domain.SubBoard;
import com.chunjae.board2.dto.SubDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRepository extends JpaRepository<SubBoard,Long> {
    @Override
    SubBoard save(SubBoard subBoard);
}

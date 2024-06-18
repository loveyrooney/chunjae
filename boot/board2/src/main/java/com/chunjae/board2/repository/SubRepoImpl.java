package com.chunjae.board2.repository;

import static com.chunjae.board2.domain.QMyBoard.*;
import static com.chunjae.board2.domain.QSubBoard.*;

import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.dto.SubDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubRepoImpl implements SubRepo {
    private final JPAQueryFactory queryFactory;

    @Override
    public MyBoardDTO detail(Long boardId){
        MyBoardDTO dto = queryFactory.select(Projections.fields(
                MyBoardDTO.class
                , myBoard.boardId
                , myBoard.title
                , myBoard.content
                , myBoard.writeDate
                , myBoard.updateDate))
                .from(myBoard)
                .where(myBoard.boardId.eq(boardId))
                .fetchOne();
        return dto;
    }

    @Override
    public List<SubDTO> findSublist(Long boardId) {
        // subBoard 에 조건을 달아서 가져올 건지, myBoard 에 있는 리스트를 가져올 건지에 따라 다르다.
        List<SubDTO> list = queryFactory.select(Projections.fields(
                SubDTO.class
                ,subBoard.subId
                ,subBoard.content))
                .from(subBoard)
                .where(subBoard.board.boardId.eq(boardId))
                .orderBy(subBoard.subId.desc())
                .fetch();
        return list;
    }
}

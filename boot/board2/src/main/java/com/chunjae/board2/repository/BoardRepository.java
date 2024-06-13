package com.chunjae.board2.repository;

import com.chunjae.board2.domain.MyBoard;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<MyBoard,Long> {
    // jpa 제공 메서드를 사용하는 방법
    List<MyBoard> findByTitleContaining(String title);

    // 쿼리를 직접 사용하는 방법
    @Query("select b from MyBoard b where b.title like concat('%', :title, '%')")
    List<MyBoard> findTitles(Pageable pageable, String title);

    // Object[] 로 받는 방법
    @Query("select b.boardId, b.title, b.content from MyBoard b where b.title = :title")
    List<Object[]> findData(@Param("title") String title);

    @Query("select count(b) from MyBoard b where b.title like concat('%', :title, '%')")
    Integer listCount(String title);

    @Modifying(clearAutomatically = true) // 쿼리로 update 시 em.clear() 해주는 설정
    @Query("update MyBoard b set b.title = concat('',:boardId) where b.boardId = :boardId")
    int modify(@Param("boardId") Long bid);

    @Override
    Optional<MyBoard> findById(Long aLong);

    @Override
    MyBoard save(MyBoard board);
}

package com.chunjae.board2.service;

import com.chunjae.board2.domain.MyBoard;
import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.repository.BoardRepository;
import com.chunjae.board2.repository.SubRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final SubRepo subRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<MyBoardDTO> findBoardList(String title) {
        List<MyBoard> titlelist = boardRepository.findByTitleContaining(title);
        List<MyBoardDTO> list = titlelist.stream().map(item->modelMapper.map(item,MyBoardDTO.class))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    @Transactional
    public Page<MyBoardDTO> findTitles(Pageable pageable, String title) {
        int count = listCount(title);
        List<MyBoard> titlelist = boardRepository.findTitles(pageable,title);
        List<MyBoardDTO> list = new ArrayList<>();
        if(titlelist.isEmpty())
            return new PageImpl<>(list,pageable,count);
        list = titlelist.stream().map(item->modelMapper.map(item,MyBoardDTO.class))
                .collect(Collectors.toList());
        // PageImpl<> 객체의 생성자에는 list, pageable 객체, list 길이 를 넣을 수 있다.
        // list.size()는 해당 page 단위로 분절된 리스트의 사이즈이다.
        // 마지막 페이지 구현을 위해 전체 리스트의 사이즈를 count 쿼리로 계산하였다.
        return new PageImpl<>(list,pageable,count);
    }

    @Override
    public List<MyBoardDTO> findData(String title) {
        List<Object[]> datas = boardRepository.findData(title);
        List<MyBoardDTO> result = datas.stream().map(item-> MyBoardDTO.builder()
                .boardId((Long)item[0])
                .title((String)item[1])
                .content((String) item[2])
                .build()).collect(Collectors.toList());
        return result;
    }

    @Override
    public int listCount(String title) {
        return boardRepository.listCount(title);
    }

    @Override
    public int modify(Long bid) {
        return boardRepository.modify(bid);
    }

    @Override
    @Transactional
    public void updateData(MyBoardDTO dto) {
        Optional<MyBoard> target = boardRepository.findById(dto.getBoardId());
        MyBoard board = target.orElseThrow(()->{throw new RuntimeException();});
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
    }

    @Override
    public MyBoardDTO detail(Long boardId) {
//        Optional<MyBoard> board = boardRepository.findById(boardId);
//        MyBoardDTO dto = board.stream().map(item->modelMapper.map(item,MyBoardDTO.class))
//                .findAny().orElseThrow();
          MyBoardDTO dto = subRepo.detail(boardId);
        return dto;
    }

    @Override
    public void writeNew(MyBoardDTO dto) {
        // modelMapper.map(MyBoard.class) 를 하게 되면 엔티티의 모든 필드가 db와 연결된다.
        // 만약 엔티티의 필드들 중 db와 연결될 필요 없는 부분들이 있으면 빌더 패턴으로 필요한 필드만 설정
        // setter 를 엔티티에 사용하는 것 지양할 것.
        MyBoard newBoard = MyBoard.builder()
                .boardId(dto.getBoardId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writeDate(dto.getWriteDate())
                .updateDate(dto.getUpdateDate())
                .build();
        MyBoard board = boardRepository.save(newBoard);
        log.info("insert board...{}",board.getBoardId()+board.getTitle());
    }

    @Override
    public void deleteData(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
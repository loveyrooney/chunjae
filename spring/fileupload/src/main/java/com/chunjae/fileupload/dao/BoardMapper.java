package com.chunjae.fileupload.dao;

import com.chunjae.fileupload.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {


    int insert(HashMap<String, Object> o);
    int subinsert(HashMap<String, Object> o);

    List<BoardDTO> list();

}

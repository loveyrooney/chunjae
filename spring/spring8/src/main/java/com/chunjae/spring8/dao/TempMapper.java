package com.chunjae.spring8.dao;

import com.chunjae.spring8.dto.TempDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface TempMapper {
    List<TempDTO> findTempList(int did);
    int insertTemp(HashMap<String, Object> hm);
}

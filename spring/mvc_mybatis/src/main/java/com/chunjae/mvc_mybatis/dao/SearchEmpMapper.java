package com.chunjae.mvc_mybatis.dao;

import com.chunjae.mvc_mybatis.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface SearchEmpMapper {
    int totalCount(HashMap<String,Object> param);
    List<EmpDTO> findSearchList(HashMap<String, Object> param);
    List<HashMap<String, Object>> searchEmpListReturnedMap();
}

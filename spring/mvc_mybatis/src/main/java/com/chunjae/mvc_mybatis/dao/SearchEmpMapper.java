package com.chunjae.mvc_mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface SearchEmpMapper {
    int totalCount(HashMap<String,Object> param);
}

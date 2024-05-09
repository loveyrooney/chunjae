package com.chunjae.mvc_mybatis.dao;

import com.chunjae.mvc_mybatis.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpMapper {
    List<EmpDTO> findEmpList();
}

package com.chunjae.transaction.dao;

import com.chunjae.transaction.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface EmpMapper {
    EmpDTO findEmp(int eid);
    int insertEmp(EmpDTO dto);
    int updateEmp(HashMap<String,Object> o);
    int deleteEmp(int eid);
}

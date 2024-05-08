package com.chunjae.spring_day6.dao;

import com.chunjae.spring_day6.dto.EmpDTO;

import java.util.List;

public interface EmpMapper {
    List<EmpDTO> findEmplist();
    int insertEmp(EmpDTO dto);
    EmpDTO findEmp(String eid);
}

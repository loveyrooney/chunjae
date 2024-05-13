package com.chunjae.spring7.dao;

import com.chunjae.spring7.dto.EmpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface EmpMapper {
    int countEmpList(HashMap<String,Object> param);
    List<EmpDTO> findEmpList(HashMap<String,Object> param);
    EmpDTO findEmp(int employee_id);

    void updateEmp(EmpDTO dto);
    void deleteEmp(int eid);
}

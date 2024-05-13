package com.chunjae.mvc_mybatis.service;

import com.chunjae.mvc_mybatis.dao.EmpMapper;
import com.chunjae.mvc_mybatis.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("empService")
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService{
    private final EmpMapper empMapper;

    @Override
    public List<EmpDTO> empList() {
        List<EmpDTO> emp_list = empMapper.findEmpList();
        return emp_list;
    }
}

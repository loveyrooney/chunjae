package com.chunjae.spring7.service;

import com.chunjae.spring7.dto.EmpDTO;

import java.util.List;

public interface EmpService {
    int countEmpList(String search, String searchTxt);
    List<EmpDTO> empList(String search, String searchTxt, int startRow, int pageSize);
    EmpDTO detailEmp(int employee_id);
}

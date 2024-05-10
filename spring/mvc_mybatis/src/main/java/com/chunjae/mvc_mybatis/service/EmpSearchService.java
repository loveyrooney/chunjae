package com.chunjae.mvc_mybatis.service;

import com.chunjae.mvc_mybatis.dto.EmpDTO;

import java.util.HashMap;
import java.util.List;

public interface EmpSearchService {
    int totalCount(String search, String search_txt);
    List<EmpDTO> searchEmpList(String search, String search_txt, int start, int pageSize);
    List<HashMap<String,Object>> searchEmpListReturnedMap();
}

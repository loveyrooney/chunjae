package com.chunjae.spring_day6.serivce;

import com.chunjae.spring_day6.dto.EmpDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpService {
   List<EmpDTO> list();
    int insert(EmpDTO dto);
    EmpDTO detail(String eid);
}

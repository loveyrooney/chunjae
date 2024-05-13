package com.chunjae.spring7.service;

import com.chunjae.spring7.dao.EmpMapper;
import com.chunjae.spring7.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {
    private final EmpMapper mapper;
    public EmpServiceImpl(EmpMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public int countEmpList(String search, String searchTxt) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("search",search);
        param.put("searchTxt",searchTxt);
        int result = mapper.countEmpList(param);
        return result;
    }

    @Override
    public List<EmpDTO> empList(String search, String searchTxt, int startRow, int pageSize) {
        HashMap<String,Object> param = new HashMap<>();
        param.put("search",search);
        param.put("searchTxt",searchTxt);
        param.put("startRow",startRow);
        param.put("pageSize",pageSize);
        List<EmpDTO> list = mapper.findEmpList(param);
        return list;
    }

    @Override
    public EmpDTO detailEmp(int employee_id) {
        EmpDTO emp = mapper.findEmp(employee_id);
        return emp;
    }

    @Override
    public void updateEmp(EmpDTO dto) {
        mapper.updateEmp(dto);
    }

    @Override
    public void deleteEmp(int eid) {
        mapper.deleteEmp(eid);
    }
}

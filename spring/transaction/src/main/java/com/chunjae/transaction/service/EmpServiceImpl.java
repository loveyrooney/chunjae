package com.chunjae.transaction.service;

import com.chunjae.transaction.dao.EmpMapper;
import com.chunjae.transaction.dto.EmpDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service(value = "empService")
public class EmpServiceImpl implements EmpService{
    private EmpMapper mapper;
    public EmpServiceImpl(EmpMapper mapper){
        this.mapper=mapper;
    }

    // 메서드 단위로도 사용할 수 있고, 클래스 단위로도 사용 가능
    @Transactional
    @Override
    public void doing() {
        EmpDTO dto = new EmpDTO();
        dto.setEmployee_id(11);
        dto.setLast_name("PARK");
        dto.setEmail("park@test.com");
        dto.setHire_date("2024-05-14");
        dto.setDepartment_id(90);
        mapper.insertEmp(dto);
        mapper.deleteEmp(33);
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("first_name","GANG");
        hm.put("email","gang@test.com");
        hm.put("employee_id",206);
        // update 는 first_name 이라 동작하지 않는 상황
        mapper.updateEmp(hm);
        // 이 메서드 안에 있는 모든 매퍼 메서드가 정상작동 하지 않으면 모두 rollback 처리가 된다.
    }
}

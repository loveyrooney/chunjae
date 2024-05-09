package com.chunjae.spring_day6.serivce;

import com.chunjae.spring_day6.dao.EmpMapper;
import com.chunjae.spring_day6.dto.EmpDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


@Service("empService")
public class EmpServiceImple implements  EmpService {

    private SqlSessionTemplate sqlSession;

    public EmpServiceImple(SqlSessionTemplate sqlSession)
    {
        this.sqlSession=sqlSession;
    }

    @Override
    public List<EmpDTO> list() {
       EmpMapper mapper=sqlSession.getMapper(EmpMapper.class);
        List<EmpDTO> list=  mapper.findEmplist();
        return list;
    }

    @Override
    public int insert(EmpDTO dto) {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        int result = mapper.insertEmp(dto);
        if(result>0){
            result = dto.getEmployee_id();
        }
        return result;
    }

    @Override
    public EmpDTO detail(int eid) {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpDTO dto = mapper.findEmp(eid);
        return dto;
    }

    @Override
    public void updateEmp(EmpDTO dto) {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.updateEmp(dto);
    }

    @Override
    public void delEmp(int eid) {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.delEmp(eid);
    }
}

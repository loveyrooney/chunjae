package com.chunjae.mvc_mybatis.service;

import com.chunjae.mvc_mybatis.dao.SearchEmpMapper;
import com.chunjae.mvc_mybatis.dto.EmpDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("empSearchService")
@RequiredArgsConstructor
public class EmpSearchServiceImpl implements EmpSearchService{
    private final SearchEmpMapper mapper;
    @Override
    public int totalCount(String search, String search_txt) {
        // 매개변수가 2개 이상인 모든 매퍼 메서드에 대하여 DTO 를 만들수는 없으므로
        // 엔티티에 상응하는 DTO 외에 다른 조합들은 hashMap 을 사용하도록 한다.
        HashMap<String,Object> param = new HashMap<>();
        param.put("search",search);
        param.put("search_txt",search_txt);
        return mapper.totalCount(param);
    }

    @Override
    public List<EmpDTO> searchEmpList(String search, String search_txt, int start, int pageSize) {
        //List<EmpDTO> searchlist = mapper.searchEmpList();
        // q1. count 를 db 까지 갔다 와야 하나? 그냥 list 받아서 페이지 단위로 자르면 안되는건가
        // q2. 이미 있는 쿼리를 재사용 하려고 할 때 매개변수 여부가 달라질때 조건 적용
        return null;
    }
}

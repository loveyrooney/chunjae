package com.chunjae.spring8.service;

import com.chunjae.spring8.dao.TempMapper;
import com.chunjae.spring8.dto.TempDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("tempService")
public class TempServiceImpl implements TempService{
    private TempMapper mapper;
    public TempServiceImpl(TempMapper mapper){
        this.mapper=mapper;
    }
    @Override
    public List<TempDTO> findTempList(int did) {
        return mapper.findTempList(did);
    }

    @Override
    public int insertTemp(HashMap<String, Object> hm) {
        return mapper.insertTemp(hm);
    }
}

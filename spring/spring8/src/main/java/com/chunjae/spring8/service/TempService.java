package com.chunjae.spring8.service;

import com.chunjae.spring8.dto.TempDTO;

import java.util.HashMap;
import java.util.List;

public interface TempService {
    List<TempDTO> findTempList(int did);

    int insertTemp(HashMap<String, Object> hm);
}

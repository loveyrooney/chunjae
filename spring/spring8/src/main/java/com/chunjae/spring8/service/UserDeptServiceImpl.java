package com.chunjae.spring8.service;

import com.chunjae.spring8.dao.UserDeptMapper;
import com.chunjae.spring8.dto.UserDeptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDeptService")
public class UserDeptServiceImpl implements UserDeptService {

    private final UserDeptMapper mapper;
    @Autowired
    public UserDeptServiceImpl(UserDeptMapper mapper){
        this.mapper=mapper;
    }

    @Override
    public List<UserDeptDTO> findUserDeptList() {
        List<UserDeptDTO> list = mapper.findUserDeptList();
        return list;
    }

    @Override
    public UserDeptDTO findUserDept(int did) {
        return mapper.findUserDept(did);
    }
}

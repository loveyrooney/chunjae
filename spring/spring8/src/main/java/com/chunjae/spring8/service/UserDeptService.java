package com.chunjae.spring8.service;

import com.chunjae.spring8.dto.UserDeptDTO;

import java.util.List;

public interface UserDeptService {
    List<UserDeptDTO> findUserDeptList();
    UserDeptDTO findUserDept(int did);
}

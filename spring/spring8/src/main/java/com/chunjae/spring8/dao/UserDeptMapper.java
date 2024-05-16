package com.chunjae.spring8.dao;

import com.chunjae.spring8.dto.UserDeptDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDeptMapper {
    List<UserDeptDTO> findUserDeptList();
    UserDeptDTO findUserDept(int did);
}

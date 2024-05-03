package com.chunjae.dao;

import com.chunjae.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
    List<MemberDTO> findMembers();
    MemberDTO findMember(int mid);
    int deleteMember(int mid);
    int insertMember(MemberDTO dto);

    List<MemberDTO> findMembersContainsName(String s);
    int deleteMemberWithName(String name);
    int updateMember(MemberDTO dto);
}

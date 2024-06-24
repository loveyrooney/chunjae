package com.chunjae.security.service;

import com.chunjae.security.domain.UserMember;
import com.chunjae.security.domain.UserRole;
import com.chunjae.security.dto.MemberDTO;
import com.chunjae.security.repository.UserReporitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final UserReporitory userReporitory;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Long insertMember(MemberDTO dto){
        if(findUserCheck(dto.getUsername()))
            throw new RuntimeException("기존 회원이 있습니다.");
        UserMember member = UserMember.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .irum(dto.getIrum())
                .role(UserRole.valueOf(dto.getRole()))
                .build();
        UserMember save = userReporitory.save(member);
        return save.getId();
    }

    private boolean findUserCheck(String username){
        boolean result = false;
        UserMember isUserName = userReporitory.findByUserName(username);
        if(isUserName!=null)
            result = true;
        return result;
    }
}

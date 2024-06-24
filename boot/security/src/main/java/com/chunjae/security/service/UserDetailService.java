package com.chunjae.security.service;

import com.chunjae.security.domain.UserMember;
import com.chunjae.security.repository.UserReporitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailService implements UserDetailsService {
    private final UserReporitory userReporitory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMember findUser = userReporitory.findByUserName(username);
        log.info("UserDetailService findByUserName...{}",findUser.getUsername()+","+findUser.getPassword());
        if(findUser!=null)
            return new CustomUserDetails(findUser);
        return null;
    }
}

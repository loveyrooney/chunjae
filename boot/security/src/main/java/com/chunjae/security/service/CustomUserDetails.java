package com.chunjae.security.service;

import com.chunjae.security.domain.UserMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

@Slf4j
public class CustomUserDetails implements UserDetails {
    private UserMember userMember;
    public CustomUserDetails(UserMember findUser) {
        this.userMember=findUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("findUser role...{}",userMember.getRole().name());
        Collection<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userMember.getRole().name()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userMember.getPassword();
    }

    @Override
    public String getUsername() {
        return userMember.getUsername();
    }


}

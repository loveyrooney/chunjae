package com.chunjae.security.repository;

import com.chunjae.security.domain.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReporitory extends JpaRepository<UserMember,Long> {
    @Override
    <S extends UserMember> S save(S entity);

    @Query(" select u from UserMember u where u.username =:username ")
    UserMember findByUserName(String username);
}

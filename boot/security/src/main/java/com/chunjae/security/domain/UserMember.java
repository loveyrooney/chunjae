package com.chunjae.security.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users"
        , uniqueConstraints = @UniqueConstraint(name="uk_username", columnNames = "username"))
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String irum;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}

package com.chunjae.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionProvider {
    private String driver;
    private String url;
    private String user;
    private String pwd;
}

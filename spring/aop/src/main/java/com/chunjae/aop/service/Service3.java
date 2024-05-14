package com.chunjae.aop.service;

import org.springframework.stereotype.Service;

@Service(value = "s3")
public class Service3 {
    public void write(){
        for(int i=0; i<100; i++){
            System.out.println("service3 write : "+i);
        }
    }
}

package com.chunjae.aop.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service(value = "s1")
public class Service1 {
    public void prt(){
        System.out.println("service1 prt");
    }
    public void view(){
        System.out.println("service1 view");
    }
    public int show(int su) throws IOException{
        if(su>0) {
            System.out.println("service1 show");
            su+=10;
        } else
            throw new IOException();
        return su;
    }
}

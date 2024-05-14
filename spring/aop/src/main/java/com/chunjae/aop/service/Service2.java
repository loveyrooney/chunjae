package com.chunjae.aop.service;

import org.springframework.stereotype.Service;

@Service(value = "s2")
public class Service2 {
    public void write(){
        System.out.println("service2 write");
    }
    public void read(){
        System.out.println("service2 read");
    }
    public void view(){
        System.out.println("service2 view");
    }
    public int read(String[] books) throws ArrayIndexOutOfBoundsException {
        System.out.println("read books .. ");
        if(books.length<2)
            throw new ArrayIndexOutOfBoundsException();
        return books.length;
    }
}

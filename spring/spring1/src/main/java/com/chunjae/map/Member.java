package com.chunjae.map;

import lombok.Setter;

import java.util.Map;

@Setter
public class Member {
    private Map<String,Category> item;
    public void prt(){
        for(String k :item.keySet()){
            System.out.println(k+" : "+item.get(k)+", ");
        }
    }
}

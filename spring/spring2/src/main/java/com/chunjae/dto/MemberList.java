package com.chunjae.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class MemberList {
    private List<MemberDTO> list;
    public void prt(){
        for(MemberDTO dto:list){
            System.out.printf("%s, %d\n",dto.getName(),dto.getAge());
        }
    }
}

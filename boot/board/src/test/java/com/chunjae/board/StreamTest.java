package com.chunjae.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        String[] arr = new String[]{"kim","lee","son"};
        // array forEach : forEach는 하나씩 동작하고 끝. void 느낌
        Arrays.stream(arr).forEach(item->{
            System.out.println("foreach: "+item);
        });
        // array map : map 은 하나씩 동작을 해서 결과를 리턴해 줄 수 있다.
        List<String> data = Arrays.stream(arr)
                                    .map(item->"hello"+item)
                                    .collect(Collectors.toList());
        for(String item:data){
            System.out.println("map: "+item);
        }
        // list map
        List<String> list = new ArrayList<>();
        list.add("cha");
        list.add("cho");
        list.add("park");
        List<String> newlist = list.stream().map(item->"change"+item).collect(Collectors.toList());
        for(String s:newlist){
            System.out.println(s);
        }
    }
}

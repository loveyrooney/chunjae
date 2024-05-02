package com.chunjae.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberMap {
    private Map<String,MemberDTO> memberMap = new HashMap<>();
}

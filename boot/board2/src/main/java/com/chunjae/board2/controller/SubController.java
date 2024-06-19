package com.chunjae.board2.controller;

import com.chunjae.board2.dto.SubDTO;
import com.chunjae.board2.service.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubController {
    private final SubService subService;
    @GetMapping("/sublist/{boardId}")
    public ResponseEntity<List<SubDTO>> sublist(@PathVariable Long boardId){
        List<SubDTO> sublist = subService.sublist(boardId);
        return ResponseEntity.ok().body(sublist);
    }

    @PostMapping("/insertsub")
    public ResponseEntity<Long> insertsub(@RequestBody SubDTO dto){
        Long subId = subService.insertSub(dto);
        return ResponseEntity.ok().body(subId);
    }
}

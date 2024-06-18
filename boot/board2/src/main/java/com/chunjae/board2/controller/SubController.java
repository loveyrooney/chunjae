package com.chunjae.board2.controller;

import com.chunjae.board2.dto.SubDTO;
import com.chunjae.board2.service.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}

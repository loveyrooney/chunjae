package com.chunjae.fileupload.service;

import com.chunjae.fileupload.dto.BoardDTO;
import com.chunjae.fileupload.dto.InfoDTO;

import java.io.IOException;
import java.util.List;

public interface BoardService {

     int  write(String path, InfoDTO dto) throws IOException;

     List<BoardDTO> list();
}

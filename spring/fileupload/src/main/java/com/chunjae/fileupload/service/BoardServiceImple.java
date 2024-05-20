package com.chunjae.fileupload.service;

import com.chunjae.fileupload.dao.BoardMapper;
import com.chunjae.fileupload.dto.BoardDTO;
import com.chunjae.fileupload.dto.InfoDTO;
import org.apache.ibatis.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImple implements BoardService {
  private static final Logger logger= LoggerFactory.getLogger(BoardServiceImple.class);
     private BoardMapper mapper;

     @Autowired
     public BoardServiceImple(BoardMapper mapper)
     {
         this.mapper=mapper;
     }
    @Transactional
    @Override
    public int write(String path, InfoDTO dto) throws  IOException {
         Logger logger=LoggerFactory.getLogger(BoardServiceImple.class);
         logger.info(".....  board service imple  dto...{}", dto.getFiles().length);
        HashMap<String, Object> o = new HashMap<>();
            o.put("dto", dto);

        if(dto.getFiles()!=null) {
               String[] fnames = fileUpload(path, dto);
               List<String> filenames = Arrays.asList(fnames);
            o.put("filenames", filenames);
            logger.info("filenames....{}",filenames.get(0));
           }
        mapper.insert(o);
        int result=0;
        if(dto.getFiles()!=null) {
           result= mapper.subinsert(o);
        }
        logger.info("key out {}",o.get("id"));
       logger.info("data complete... {}", result);
       return result;
    }

    @Override
    public List<BoardDTO> list() {

         return   mapper.list();

    }

    private  String[]  fileUpload(String path, InfoDTO dto) {
        System.out.println(dto.getFiles().length + "........length.....");
            File[] saveFile = new File[dto.getFiles().length];
            String[] filenames = new String[dto.getFiles().length];

            for (int i = 0; i < dto.getFiles().length; i++) {
                UUID uuid = UUID.randomUUID();

                String fname=  dto.getFiles()[i].getOriginalFilename();
                System.out.println("original filename ,..."+fname);

                System.out.println("fname...."+fname);
                fname=URLEncoder.encode(fname, StandardCharsets.UTF_8)
                        .replace("+", "%20");
                String filename = uuid + "_" +fname;
                saveFile[i] = new File(path, filename);
                System.out.println("filename....length : "+filename.length());
                filenames[i] = filename;
            } // file 생성

            try {
                for (int i = 0; i < saveFile.length; i++) {
                    dto.getFiles()[i].transferTo(saveFile[i]);
                }
            } catch (IOException e) {
                for (int i = 0; i < saveFile.length; i++)
                    saveFile[i].delete();
                throw new RuntimeException();
            }
            return filenames;

        }
    }



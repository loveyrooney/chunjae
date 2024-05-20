package com.chunjae.fileupload.controller;

import com.chunjae.fileupload.dto.BoardDTO;
import com.chunjae.fileupload.dto.InfoDTO;
//import com.chunjae.fileupload.service.BoardService;
import com.chunjae.fileupload.service.BoardService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class FileUploadController {

    private BoardService service;
    @Autowired
    public FileUploadController(BoardService service)
    {
        this.service=service;
    }

    @GetMapping("/uploadform")
      public String form(){

            return "uploadform";

      }
      @PostMapping("/formresult")
      public String result(HttpServletRequest request, InfoDTO dto, Model model){
          String base="/uploadImg";

          String realpath= request.getSession().getServletContext().getRealPath(base);
          System.out.println("realpath....."+realpath);
           try {

               service.write(realpath, dto);
           } catch(IOException e)
           {
               System.out.println(e);
           }
         return "redirect:/list";
      }
//
    @GetMapping("/list")
      public String list(Model model){
           List<BoardDTO> list=service.list();
            model.addAttribute("list", list);
            return "boardlist";
      }




}

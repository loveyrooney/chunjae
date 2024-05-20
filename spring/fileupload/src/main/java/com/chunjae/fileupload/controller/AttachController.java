package com.chunjae.fileupload.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AttachController {
    @GetMapping(value="/download/{filename}")
    @ResponseBody
    public  ResponseEntity<Resource> getFile(@PathVariable String filename, HttpServletRequest request, HttpServletResponse response){

        String path="uploadImg";
        String realpath=  request.getSession().getServletContext().getRealPath(path);

        String fname= URLEncoder.encode(filename, StandardCharsets.UTF_8).replace("+","%20");

        File file=new File(realpath+"/" + fname);
        if(!file.exists()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        HttpHeaders headers = new HttpHeaders();

        Resource resource;
           try {
             resource= new InputStreamResource(new FileInputStream(file));
               response.setHeader("Content-Type", "application/octet-stream");
               response.setHeader("Content-Disposition", "attachment; filename="+fname);
               headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
               headers.add("Pragma", "no-cache");
               headers.add("Expires", "0");
               headers.add("contentType","utf-8");
               headers.setContentLength(file.length());
               headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
           } catch(IOException e)
           {
               System.out.println("error....."+e);
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
        return new ResponseEntity<>( resource, headers, HttpStatus.OK);
       }
}

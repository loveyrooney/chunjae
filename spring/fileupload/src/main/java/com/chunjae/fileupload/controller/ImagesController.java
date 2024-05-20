package com.chunjae.fileupload.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class ImagesController {
    @GetMapping( value="/getImage/{filename}"
       ,produces = {MediaType.IMAGE_GIF_VALUE
                   , MediaType.IMAGE_PNG_VALUE})
    public  ResponseEntity<byte[]>  getImage(@PathVariable String filename
            , HttpServletRequest request) {
        String path="/uploadImg";
        String realpath= request.getSession().getServletContext().getRealPath(path);
        String fname = URLEncoder.encode(filename,StandardCharsets.UTF_8).replace("+", "%20");
        InputStream in = null;
        ResponseEntity<byte[]> entity=null;
        try {
            in = new FileInputStream(realpath + "/" + fname);
            System.out.println("in....."+in);
            HttpHeaders headers=new HttpHeaders();
            entity=new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(in)
                    ,headers,  HttpStatus.OK);
        }catch(IOException  e)
        {
            System.out.println(e+".....file not founcd 안녕!!!!!!!!!");
            entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

}

    //    @CrossOrigin
//    @GetMapping("/image/{imgsrc}")
//    @ResponseBody
//    public ResponseEntity<?> returnImage(@PathVariable("imgsrc")
//    String imageName, HttpServletRequest request) {
//        String path = "resources/upload"; //이미지가 저장된 위치
//         String realpath=request.getSession().getServletContext().getRealPath(path);
////         HttpHeaders header=new HttpHeaders();
////         header.add("Content-Tyype", "");
//        Resource resource = new FileSystemResource(realpath + imageName);
//        return new ResponseEntity<>(resource, HttpStatus.OK);
//    }
//    @GetMapping("/attach/{itemId}")
//    public ResponseEntity<Resource> downloadAttach(@PathVariable Long itemId) throws MalformedURLException {
//        //...itemId 이용해서 고객이 업로드한 파일 이름인 uploadFileName랑 서버 내부에서 사용하는 파일 이름인 storeFileName을 얻는다는 내용은 생략
//
//        UrlResource resource = new UrlResource("file:" + fileStore.getFullPath(storeFileName));
//
//        //한글 파일 이름이나 특수 문자의 경우 깨질 수 있으니 인코딩 한번 해주기
//        String encodedUploadFileName = UriUtils.encode(uploadFileName,
//                StandardCharsets.UTF_8);
//
//        //아래 문자를 ResponseHeader에 넣어줘야 한다. 그래야 링크를 눌렀을 때 다운이 된다.
//        //정해진 규칙이다.
//        String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
//                .body(resource);
//    }
//}

package com.chunjae.login_upload.controller;

import com.chunjae.login_upload.dto.FileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
    private final String upload = "temp";
    private final Logger logger = LoggerFactory.getLogger("LoginController.class");
    @PostMapping("/form_result")
    public String formresult(HttpServletRequest request, FileDTO dto, Model model){
        MultipartFile multi = dto.getFile1();
        try{
            String uploadPath = request.getSession().getServletContext().getRealPath(upload);
            if(!multi.isEmpty()){
                // uuid 보다는 같은 파일명인지 확인해서 있으면 (2) 를 만드는거 해보기
                // (2) 를 만드는 차원을 서버에서 임의로 할 수도 있고
                // 전송하려고 할 때 걸려서 클라이언트가 파일명을 수정하게 할 수도 있다. 이경우 해당 포스트 요청은 fetch
                UUID uuid = UUID.randomUUID();
                String filename = uuid+"_"+multi.getOriginalFilename();
                File file = new File(uploadPath,filename);
                multi.transferTo(file);
                model.addAttribute("filename",dto.getFileName());
                model.addAttribute("fname",filename);
                model.addAttribute("uploadpath",file.getAbsolutePath());
                return "service2";
            }
        }catch (IOException e){
            logger.info("upload fail : {}"+e.getMessage());
        }
        return "redirect:/service1";
    }

}

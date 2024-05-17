package com.chunjae.login_upload.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class DownloadController implements ApplicationContextAware {
    private ApplicationContext context=null;

    @GetMapping("/download/{fname}")
    public ModelAndView download(@PathVariable("fname") String fname, HttpServletRequest request){
        String fullpath = request.getSession().getServletContext().getRealPath("temp/"+fname);
        File file = new File(fullpath);
        return new ModelAndView("downloadView","downloadFile",file);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        // TODO Auto-generated method stub
        this.context=context;
    }
}

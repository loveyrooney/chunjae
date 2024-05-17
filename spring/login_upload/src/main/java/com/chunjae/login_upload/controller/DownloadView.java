package com.chunjae.login_upload.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

public class DownloadView extends AbstractView {
    public DownloadView() {
        // TODO Auto-generated constructor stub
        setContentType("application/octet-stream");
    }


    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request
            , HttpServletResponse response)
            throws Exception {
        File file = (File) map.get("downloadFile");
        response.setContentType(getContentType());
        response.setContentLength((int) file.length());
        response.setHeader("content-Disposition"
                ,"attachment; filename=\""+URLEncoder.encode(file.getName(),"utf-8")+"\";");
        response.setHeader("Content-transfer-Encoding", "binary");
        try (FileInputStream fis = new FileInputStream(file);
             OutputStream out = response.getOutputStream();) {
            FileCopyUtils.copy(fis, out);
            out.flush();
        }

    }
}

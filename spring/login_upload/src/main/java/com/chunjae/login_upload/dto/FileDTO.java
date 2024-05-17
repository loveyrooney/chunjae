package com.chunjae.login_upload.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
    private String fileName;
    private MultipartFile file1;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getFile1() {
        return file1;
    }

    public void setFile1(MultipartFile file1) {
        this.file1 = file1;
    }
}

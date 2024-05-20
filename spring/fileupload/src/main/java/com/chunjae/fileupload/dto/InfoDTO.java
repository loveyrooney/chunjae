package com.chunjae.fileupload.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


public class InfoDTO {

  private int infoId;
  private String title;
  private MultipartFile[] files;

  public int getInfoId() {
    return infoId;
  }

  public void setInfoId(int infoId) {
    this.infoId = infoId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public MultipartFile[] getFiles() {
    return files;
  }

  public void setFiles(MultipartFile[] files) {
    this.files = files;
  }
}

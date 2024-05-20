package com.chunjae.fileupload.dto;

import lombok.Getter;
import lombok.Setter;


public class BoardDTO {
      private int infoId;
      private String infotitle;

      private String filenames;


      public int getInfoId() {
            return infoId;
      }

      public void setInfoId(int infoId) {
            this.infoId = infoId;
      }

      public String getInfotitle() {
            return infotitle;
      }

      public void setInfotitle(String infotitle) {
            this.infotitle = infotitle;
      }

      public String getFilenames() {
            return filenames;
      }

      public void setFilenames(String filenames) {
            this.filenames = filenames;
      }




}

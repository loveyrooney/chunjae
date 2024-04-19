package com.chunjae.dto;

public class ReplyDTO {
    private int subno;
    private String subcontent;
    private String writer;
    private int boardno;

    public int getSubno() {
        return subno;
    }

    public void setSubno(int subno) {
        this.subno = subno;
    }

    public String getSubcontent() {
        return subcontent;
    }

    public void setSubcontent(String subcontent) {
        this.subcontent = subcontent;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getBoardno() {
        return boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }
}

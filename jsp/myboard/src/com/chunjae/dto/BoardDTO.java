package com.chunjae.dto;

import java.time.LocalDate;

public class BoardDTO {
    private int boardno;
    private String title;
    private String content;
    private String writer;
    private LocalDate writedate;
    private int readno;

    public int getBoardno() {
        return boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getWritedate() {
        return writedate;
    }

    public void setWritedate(LocalDate writedate) {
        this.writedate = writedate;
    }

    public int getReadno() {
        return readno;
    }

    public void setReadno(int readno) {
        this.readno = readno;
    }
}

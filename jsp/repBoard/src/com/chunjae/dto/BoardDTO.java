package com.chunjae.dto;

public class BoardDTO {
    private int boardno;
    private String boardtitle;
    private String boardcontent;

    public int getBoardno() {
        return boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }

    public String getBoardtitle() {
        return boardtitle;
    }

    public void setBoardtitle(String boardtitle) {
        this.boardtitle = boardtitle;
    }

    public String getBoardcontent() {
        return boardcontent;
    }

    public void setBoardcontent(String boardcontent) {
        this.boardcontent = boardcontent;
    }
}

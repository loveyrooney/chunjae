package com.chunjae.dao;

import com.chunjae.dto.BoardDTO;
import com.chunjae.dto.ReplyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private static BoardDAO boardDAO = new BoardDAO();
    private BoardDAO() {
    }
    public static BoardDAO getBoardDAO() {
        return boardDAO;
    }
    public List<BoardDTO> findBoardList(Connection conn) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT boardno      ");
        sql.append("        , boardtitle ");
        sql.append(" FROM board          ");
        ArrayList<BoardDTO> list = new ArrayList<>();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();){
            while(rs.next()){
                BoardDTO dto = new BoardDTO();
                dto.setBoardno(rs.getInt("boardno"));
                dto.setBoardtitle(rs.getString("boardtitle"));
                list.add(dto);
            }
        }
        return list;
    }

    public void insertBoard(Connection conn, BoardDTO dto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" INSERT INTO board ( boardtitle      ");
        sql.append("                    , boardcontent ) ");
        sql.append(" VALUES ( ? ,? )                     ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setString(1,dto.getBoardtitle());
            pstmt.setString(2,dto.getBoardcontent());
            pstmt.executeUpdate();
        }
    }

    public BoardDTO findBoard(Connection conn, int bno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT boardno        ");
        sql.append("        , boardtitle   ");
        sql.append("        , boardcontent ");
        sql.append(" FROM board            ");
        sql.append(" WHERE boardno = ?     ");
        ResultSet rs = null;
        BoardDTO dto = new BoardDTO();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
            pstmt.setInt(1,bno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                dto.setBoardno(rs.getInt("boardno"));
                dto.setBoardtitle(rs.getString("boardtitle"));
                dto.setBoardcontent(rs.getString("boardcontent"));
            }
        }finally {
            if(rs!=null)try{rs.close();}catch (Exception e){}
        }
        return dto;
    }


}

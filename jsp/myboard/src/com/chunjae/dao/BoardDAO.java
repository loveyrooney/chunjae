package com.chunjae.dao;

import com.chunjae.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private static BoardDAO dao = new BoardDAO();
    public static BoardDAO getDao() {
        return dao;
    }
    private BoardDAO() {
    }
    public List<BoardDTO> findAll(Connection conn){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT boardno   ");
        sql.append("       ,title     ");
        sql.append("       ,writer    ");
        sql.append("       ,writedate ");
        sql.append("       ,readno    ");
        sql.append(" FROM myboard     ");
        ResultSet rs = null;
        ArrayList<BoardDTO> list = new ArrayList<>();
        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
            rs = pstmt.executeQuery();
            while(rs.next()){
                BoardDTO dto = new BoardDTO();
                dto.setBoardno(rs.getInt("boardno"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setWritedate(rs.getDate("writedate").toLocalDate());
                dto.setReadno(rs.getInt("readno"));
                list.add(dto);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(rs!=null)try{rs.close();}catch (Exception e){}
        }
        return list;
    }

    public BoardDTO findOne(Connection conn, int boardno) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT boardno    ");
        sql.append("       ,title      ");
        sql.append("       ,content    ");
        sql.append("       ,writer     ");
        sql.append("       ,writedate  ");
        sql.append("       ,readno     ");
        sql.append(" FROM myboard      ");
        sql.append(" WHERE boardno = ? ");
        ResultSet rs = null;
        BoardDTO dto = new BoardDTO();
        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
            pstmt.setInt(1,boardno);
            rs = pstmt.executeQuery();
            while(rs.next()){
                dto.setBoardno(rs.getInt("boardno"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setWriter(rs.getString("writer"));
                dto.setWritedate(rs.getDate("writedate").toLocalDate());
                dto.setReadno(rs.getInt("readno"));
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(rs!=null)try{rs.close();}catch (Exception e){}
        }
        return dto;
    }
}

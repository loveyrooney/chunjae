package com.chunjae.service;

import com.chunjae.comm.DBConnection;
import com.chunjae.dao.ImgDAO;
import com.chunjae.dto.ImgDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImgService {
    private static ImgService service = new ImgService();
    private ImgService() {
    }
    public static ImgService getService() {
        return service;
    }

    public void writeBoard(ImgDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        try{
            conn = db.getConnection();
            ImgDAO dao = ImgDAO.getDao();
            dao.insertBoard(conn,dto);
        }catch (SQLException| NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
    }

    public List<ImgDTO> findImgList() {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ArrayList<ImgDTO> list = new ArrayList<>();
        try{
            conn = db.getConnection();
            ImgDAO dao = ImgDAO.getDao();
            list = dao.findImgList(conn);
        }catch (SQLException|NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return list;
    }

    public ImgDTO findImgBoard(int bno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ImgDTO board = new ImgDTO();
        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            ImgDAO dao = ImgDAO.getDao();
            dao.countBoard(conn, bno);
            board = dao.findImgBoard(conn,bno);
            conn.commit();
        }catch (SQLException|NamingException e){
            try{conn.rollback();}catch (SQLException e2){
                System.out.println(e2.getMessage());
            }
        }
        return board;
    }
}

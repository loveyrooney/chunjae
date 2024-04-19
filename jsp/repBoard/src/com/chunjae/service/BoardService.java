package com.chunjae.service;

import com.chunjae.comm.DBConnection;
import com.chunjae.dao.BoardDAO;
import com.chunjae.dao.ReplyDAO;
import com.chunjae.dto.BoardDTO;
import com.chunjae.dto.ReplyDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private static BoardService boardService = new BoardService();
    private BoardService() {
    }
    public static BoardService getBoardService() {
        return boardService;
    }
    public List<BoardDTO> readBoardList(){
        Connection conn = null;
        DBConnection db = DBConnection.getInstance();
        BoardDAO dao = BoardDAO.getBoardDAO();
        List<BoardDTO> list = new ArrayList<>();
        try{
            conn = db.getConnection();
            list = dao.findBoardList(conn);
        }catch (SQLException| NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return list;
    }

    public void writeBoard(BoardDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDAO dao = BoardDAO.getBoardDAO();
        try{
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.insertBoard(conn,dto);
            conn.commit();
        }catch (SQLException|NamingException e){
            try{conn.rollback();}catch (SQLException e2){
                System.out.println(e2.getMessage());
            }
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
    }

    public BoardDTO readBoard(int bno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDAO dao = BoardDAO.getBoardDAO();
        BoardDTO dto = new BoardDTO();
        try{
            conn = db.getConnection();
            dto = dao.findBoard(conn,bno);
        }catch (SQLException|NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return dto;
    }

    public void writeReply(ReplyDTO repdto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ReplyDAO repdao = ReplyDAO.getReplyDAO();
        try{
            conn = db.getConnection();
            repdao.insertReply(conn,repdto);
        }catch (SQLException|NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn !=null)try{conn.close();}catch (Exception e){}
        }
    }

    public List<ReplyDTO> readReply(int bno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ReplyDAO dao = ReplyDAO.getReplyDAO();
        List<ReplyDTO> replist = new ArrayList<>();
        try{
            conn = db.getConnection();
            replist = dao.findReplyList(conn,bno);
        }catch (SQLException|NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn!=null)try{conn.close();}catch (Exception e){}
        }
        return replist;
    }

    public void deleteReply(int subno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ReplyDAO dao = ReplyDAO.getReplyDAO();
        try{
            conn = db.getConnection();
            dao.deleteReply(conn,subno);
        }catch (SQLException|NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn !=null)try{conn.close();}catch (Exception e){}
        }
    }

    public void modifyReply(ReplyDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        ReplyDAO dao = ReplyDAO.getReplyDAO();
        try{
            conn=db.getConnection();
            dao.updateReply(conn,dto);
        }catch (SQLException|NamingException e){
            System.out.println(e.getMessage());
        }finally {
            if(conn !=null)try{conn.close();}catch (Exception e){}
        }
    }
}

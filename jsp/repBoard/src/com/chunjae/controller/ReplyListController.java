package com.chunjae.controller;

import com.chunjae.dto.ReplyDTO;
import com.chunjae.service.BoardService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="ReplyListController", urlPatterns = "/replylist")
public class ReplyListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    private void doReq(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        BoardService service = BoardService.getBoardService();
        List<ReplyDTO> replist = service.readReply(bno);
        JSONArray repjson = new JSONArray();
        for(ReplyDTO dto :replist){
            JSONObject o = new JSONObject();
            o.put("subno",dto.getSubno());
            o.put("subcontent",dto.getSubcontent());
            o.put("writer",dto.getWriter());
            repjson.add(o);
        }
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(repjson);
    }
}

package com.chunjae.comm;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="DownloadController", urlPatterns = "/download")
public class DownloadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    private void doReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /*  download 시 파일 제목에 특수문자 때문에 적용 안될 때는
        tomcat 설치 파일 -> conf -> server.xml 파일에서 -> Connector port="8080" 인 태그내에 아래 속성 추가
        relaxedQueryChars ="해당특수문자, 해당특수문자2"
         */
        String f = req.getParameter("file");
        String folder = req.getServletContext().getRealPath("upload");
        String filePath = folder+"/"+f;
        System.out.println(filePath);
        BufferedInputStream bis = null;
        try {
            File file = new File(filePath);
            byte[] buffer = new byte[4096]; // 버퍼 기본값
            resp.setContentType("application/octet-stream");
            String encoding = new String(f.getBytes("utf-8"),"8859_1");
            resp.setHeader("Content-Disposition","attachment;filename="+encoding);
            if(file.isFile()){
                bis= new BufferedInputStream(new FileInputStream(filePath));
                ServletOutputStream output = resp.getOutputStream();
                int readnum;
                while((readnum = bis.read(buffer,0,buffer.length)) != -1){
                    output.write(buffer,0,readnum);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }finally{
            if(bis!=null)try{bis.close();}catch (Exception e){}
        }

    }
}

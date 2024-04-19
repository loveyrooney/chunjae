package t1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/form_json")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    private void doReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/json;charset=utf-8");
        JSONArray arr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("name","hong");
        obj.put("age",20);
        JSONObject obj2 = new JSONObject();
        obj2.put("name","박");
        obj2.put("age",10);
        arr.add(obj);
        arr.add(obj2);
        PrintWriter out = resp.getWriter();
        out.print(arr);

    }
}

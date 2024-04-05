import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/page1")
public class firstContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("servlet page1");

        // sendRedirect
        //resp.sendRedirect("page2");

        // forward 바로 하기
        //req.getRequestDispatcher("page2")
        //        .forward(req,resp);

        // forward 변수에 넣어서 하기
        RequestDispatcher dispatcher = req.getRequestDispatcher("page2");
        dispatcher.forward(req,resp);

        // forward 와 sendRedirect 를 동시에 쓰면 컴파일 오류는 안나지만 예외 발생
        // : java.lang.IllegalStateException: 응답이 이미 커밋된 후에는 forward 할 수 없습니다.
    }
}

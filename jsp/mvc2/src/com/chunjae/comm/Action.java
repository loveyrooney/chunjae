package com.chunjae.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    // 로직 처리 후 forward 할 건지 sendRedirect 여부를 결정하는 Forward 객체로 리턴한다.
    public Forward execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
}

package com.chunjae.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}

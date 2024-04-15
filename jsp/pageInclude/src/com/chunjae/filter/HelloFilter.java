package com.chunjae.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("*.do")
public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before filter - hellofilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after filter - hellofilter");

    }
}

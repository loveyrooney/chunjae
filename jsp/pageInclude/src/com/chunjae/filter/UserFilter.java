package com.chunjae.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("*.do")
public class UserFilter implements Filter {
    /*
       filter (filter javax.Servlet 상속)
       client 의 요청에서 servlet 에 도달하기 전 한번 거치는 과정에 위치한다.
       filter 의 기본 메서드는 init, doFilter, destroy로 구성.
       filterChain.doFilter() 에 req, res 를 전달하므로 이 라인을 기준으로
       req 전의 필터링과 resp 후의 필터링 작업을 할 수 있다.
       filter 는 여러 개 만들 수 있으며, filter 패키지에 올라온 순서대로 LIFO 방식으로 필터들을 거친다.
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before filter - userfilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after filter - userfilter");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

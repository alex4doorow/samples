package com.example.serv;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //Выведем ip адрес подключения в консоль
        String ipAddress = servletRequest.getRemoteAddr();
        System.out.println("ip: " + ipAddress);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
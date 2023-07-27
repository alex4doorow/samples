package com.example.serv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {
    private String message;

    public void init(){
        message = "Hello msg";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter messageWriter = response.getWriter();
        messageWriter.println("<h1>" + message + "<h1>");
    }

    public void destroy() {

    }
}

package com.example.serv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class PrintLog extends HttpServlet {

    //Инициализация сервлета
    public void init() throws ServletException {

    }

    //Метод, который по сути выдает страницу
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Устанавливает тег контента, для того чтобы русские буквы отображались корректно.
        response.setContentType("text/html;charset=UTF-8");
        //Писатель - аналог System.out.write
        PrintWriter messageWriter = response.getWriter();
        messageWriter.println("<h1>" + "Сообщения логгера" + "</h1>");
        try {
            File file = new File("c:\\src\\diximonline\\stand\\rMaster\\srv\\logs\\log-test.log");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                messageWriter.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            messageWriter.println(e);
        }
        messageWriter.println("<h4>" + "Конец логгера" + "</h4>");
    }

    public void destroy() {

    }


}
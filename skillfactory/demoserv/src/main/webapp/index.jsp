<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
    <title>Web лицо</title>
</head>
<body>
    <h2>
        Панель навигации
    </h2>
    <h4>
        <a href="http://faramir:9999/demoserv-1.0-SNAPSHOT/logger">Logger</a>
        <br>
    </h4>
    <br>
    <h2>
        Текущие данные
    </h2>
    <h4>
        Ваш ip адрес <%=request.getRemoteAddr()%>
        <br>
        Дата время <%= new Date().toString()%>
    </h4>

</body>
</html>
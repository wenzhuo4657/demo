<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2024/3/19
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.removeAttribute("first");
    response.sendRedirect("index.jsp");
%>
</body>
</html>

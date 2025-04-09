<%--
  Created by IntelliJ IDEA.
  User: 86173
  Date: 2024/3/14
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>

<form action="book.jsp" method="post">
    <input type="number" name="r">
    <input type="submit" value="提交">
    <input type="reset" value="取消">
</form>
<
欢迎您：
<%
    Object attr = session.getAttribute("first");
    if (attr != null) {
        String username = attr.toString();
        out.println(username);
    } else {
        out.println("The attribute 'first' is not found in the session.");
    }
   ServletContext b= request.getServletContext();
    out.println(b.getAttribute("num"));

%>
<br>
<jsp:include page="logo.jsp"></jsp:include>
<a href="queryall.jsp">查询界面</a>
<a href="editUser.jsp">修改页面</a>
<a href="logout.jsp">注销</a>
</body>
</html>

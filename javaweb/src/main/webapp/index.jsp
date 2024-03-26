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
欢迎您：
<%
    Object attr = session.getAttribute("first");
    if (attr != null) {
        String username = attr.toString();
        out.println(username);
    } else {
        // 可以选择在此处处理“first”属性不存在的情况，比如输出提示信息
        out.println("The attribute 'first' is not found in the session.");
    }
%>
<br>
<a href="queryall.jsp">查询界面</a>
<a href="editUser.jsp">修改页面</a>
<a href="logout.jsp">注销</a>
</body>
</html>

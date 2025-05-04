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
    Object attr = session.getAttribute("first");
    if (attr != null) {
        String username = attr.toString();
        out.println(username);
    } else {
        // 可以选择在此处处理“first”属性不存在的情况，比如输出提示信息
        out.println("The attribute 'first' is not found in the session.");
    }
%>
<form action="/unnamed/gs"   method="get">
    原密码：<input type="password" name="pre_password">
    用户名称： <input type="text" name="name" >
    新密码：<input type="password"  name="last_password">
    <input type="submit"  value="修改" >
</form>

</body>
</html>

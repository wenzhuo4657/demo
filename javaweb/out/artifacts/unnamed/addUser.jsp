<%--
  Created by IntelliJ IDEA.
  User: 17627
  Date: 2024/4/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
  
</head>
<body>
<h1>注册</h1>
<form action="/unnamed/addUser" method="post">
  用户名：<input name="username" /><br>
  密码：<input  type="password" name="password1" id="ps1"><br>
  确认密码：<input type="password"  name="passwoed2" id="ps2" ><br>
  <input type="submit" value="添加" ><input type="button" value="返回" onclick="history.go(-1);">
</form>
</body>
</html>

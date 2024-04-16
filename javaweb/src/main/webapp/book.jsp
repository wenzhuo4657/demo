<%--
  Created by IntelliJ IDEA.
  User: 86147
  Date: 2024/4/9
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="cs" class="domain.entiy.cr"/>
<jsp:setProperty name="cs" property="rs" value="#{param.r}"/>
<jsp:getProperty name="cs" property="rs"/>
</body>
</html>

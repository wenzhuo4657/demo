<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
成功
${requestScope.get("name")}
${requestScope.get("title")}
<hr>
${sessionScope.get("name")}
${sessionScope.get("title")}
</body>
</html>

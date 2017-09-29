<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/28
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--通过表单重定向--%>
<form method="post" action="/user/red">         <%--action 的跳转路径一定是要从userController的逐层写下去--%>
    <input type="text" name="id"/>
    <input type="text" name="name"/>
    <input type="submit" value="提交"/>
</form>
<form method="post" action="/user/getApost">
    <input type="text" name="id"/>
    <input type="text" name="name"/>
    <input type="submit" value="提交2"/>
</form>
</body>
</html>

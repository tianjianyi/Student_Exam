<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/7
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll.do">测试</a>
    <form action="account/save.do" method="post">
        姓名：<input type="text" name="name"><br>
        金额：<input type="text" name="money"><br>
        <input type="submit" value="保存">

    </form>
</body>
</html>

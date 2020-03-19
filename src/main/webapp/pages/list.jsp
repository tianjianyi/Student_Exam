<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/3/7
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有的账户</h3>
    ${list}
    <c:forEach items="${list}" var = "account">
        ${account.name}

    </c:forEach>

</body>
</html>

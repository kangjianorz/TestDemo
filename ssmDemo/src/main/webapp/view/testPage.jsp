<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>testPage</title>
</head>
<body>
    <h2>This is a testPage!</h2>
    <h2>Hello World!</h2>
        <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td><td>${user.name}</td><td>${user.age}</td>
        </tr>
        </c:forEach>

</body>
</html>

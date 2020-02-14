<%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 11.02.2020
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Страница авторизации</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Добро пожаловать на страницу авторизации</h1>
    <c:if test="${error != ''}">
        <p style="background-color: red">${error}</p>
    </c:if>
    <form action="${pageContext.request.contextPath}/sing-in" method="post">
            <p>
                <input type="text" name="login" placeholder="Логин">
            </p>
        <p>
        <input type="password" name="password" placeholder="Пароль">
        </p>
        <button type="submit">Авторизоваться</button>
    </form>
</div>
</body>
</html>

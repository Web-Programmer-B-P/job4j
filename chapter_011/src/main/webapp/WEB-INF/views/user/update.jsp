<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 01.02.2020
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Обновление пользователя</title>
</head>
<body>
<div style='text-align:center;'>
    <h1>Страница обновления пользователя</h1>
    <form action="${pageContext.request.contextPath}/list" method="post">
        <p>
            <strong>Имя: </strong>
            <input name='name' placeholder='Имя' value='${user.name}'>
        </p>
        <p>
            <strong>Логин: </strong>
            <input name='login' placeholder='Логин' value='${user.login}'>
        </p>
        <p>
            <strong>Пароль: </strong>
            <input name='password' placeholder='Пароль' value='${user.password}'>
        </p>
        <p>
            <strong>Почта: </strong>
            <input name='email' placeholder='Почта' value='${user.email}'>
        </p>
        <p>
            <strong>Роль: </strong>
            <select name='role'>
                <option value="${user.roleId}" hidden="" selected>${user.roleName}</option>
                <c:forEach items="${roles}" var="role">
                    <c:if test="${role.role != selected}">
                        <option value="${role.id}">${role.role}</option>
                    </c:if>
                </c:forEach>
            </select>
        </p>
        <input type='hidden' name='action' value='update'>
        <input type='hidden' name='id' value='${user.id}'>
        <td>
            <input type='submit' value='Обновить' class='submit'>
        </td>
    </form>
</div>
</body>
</html>

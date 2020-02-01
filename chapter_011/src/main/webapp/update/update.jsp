<%@ page import="ru.job4j.servlets.crud.model.User" %><%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 01.02.2020
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Обновление пользователя</title>
</head>
<body>
<%User user = (User) request.getAttribute("editUser");%>
<div style='text-align:center;'>
    <h1>Страница обновления пользователя</h1>
    <form action="<%=request.getContextPath()%>/list" method="post">
        <p>
            <strong>Имя: </strong>
            <input name='name' placeholder='Имя' value='<%=user.getName()%>'>
        </p>
        <p>
            <strong>Логин: </strong>
            <input name='login' placeholder='Логин' value='<%=user.getLogin()%>'>
        </p>
        <p>
            <strong>Почта: </strong>
            <input name='email' placeholder='Почта' value='<%=user.getEmail()%>'>
        </p>
        <input type='hidden' name='action' value='update'>
        <input type='hidden' name='id' value='<%=user.getId()%>'>
        <td>
            <input type='submit' value='Обновить' class='submit'>
        </td>
    </form>
</div>
</body>
</html>

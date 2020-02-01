<%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 01.02.2020
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание пользователя</title>
</head>
<body>
<div style='text-align:center;'>
    <h1>Страница создания пользователя</h1>
    <form action="<%=request.getContextPath()%>/list" method="post">
        <p>
            <strong>Имя: </strong>
            <input name='name' placeholder='Имя'>
        </p>
        <p>
            <strong>Логин: </strong>
            <input name='login' placeholder='Логин'>
        </p>
        <p>
            <strong>Почта: </strong>
            <input name='email' placeholder='Почта'>
        </p>
        <input type='hidden' name='action' value='add'>
        <td>
            <input type='submit' value='Создать' class='submit'>
        </td>
    </form>
</div>
</body>
</html>

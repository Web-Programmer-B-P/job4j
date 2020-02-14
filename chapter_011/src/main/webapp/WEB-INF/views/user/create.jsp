<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 01.02.2020
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Создание пользователя</title>
</head>
<body>
<div style='text-align:center;'>
    <h1>Страница создания пользователя</h1>
    <form action="${pageContext.request.contextPath}/list" method="post">
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
        <p>
            <strong>Пароль: </strong>
            <input name='password' type="password" placeholder='Пароль'>
        </p>
        <p>
            <strong>Роль: </strong>
            <select name='role'>
                <option value="" hidden="" selected>Выберите роль</option>
                <c:forEach items="${roles}" var="role">
                    <c:if test="${role.role != selected}">
                        <option value="${role.id}">${role.role}</option>
                    </c:if>
                </c:forEach>
            </select>
        </p>
        <p>
            <strong>Имя файла: </strong>
            <input name='image' placeholder='Это поле заполняется автоматически' value="${image}">
        </p>
        <input type='hidden' name='action' value='add'>
        <td>
            <input type='submit' value='Создать пользователя' class='submit'>
        </td>
    </form>
</div>
<div style="text-align: center;">
    <form action="${pageContext.request.contextPath}/create" method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="file">
        </div>
        <button type="submit" class="btn btn-default">Закрепить файл за пользователем</button>
    </form>
</div>

</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 31.01.2020
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Список пользователей</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<table cellpadding="5" width="100%" border="1">
    <tr>
        <td>Id:</td>
        <td>Имя:</td>
        <td>Логин:</td>
        <td>Почта:</td>
        <td>Фото:</td>
        <td>Скачать фото:</td>
        <td>Дата создания:</td>
        <td>Обновить</td>
        <td>Удалить</td>
    </tr>
    <jsp:useBean id="userList" scope="request" type="java.util.List"/>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>
                    ${user.id}
            </td>
            <td>
                    ${user.name}
            </td>
            <td>
                    ${user.login}
            </td>
            <td>
                    ${user.email}
            </td>
            <td>
                <img src="${pageContext.servletContext.contextPath}/download?name=${user.photoId}" width="100px"
                     height="100px"/>
            </td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/download?name=${user.photoId}">Скачать</a>
            </td>
            <td>
                <jsp:useBean id="dateValue" class="java.util.Date"/>
                <jsp:setProperty name="dateValue" property="time" value="${user.createDate}"/>
                <fmt:formatDate value="${dateValue}" pattern="dd-MM-yyyy"/>
            </td>
            <form action="${pageContext.request.contextPath}/edit" method="get">
                <input type='hidden' name='action' value='update'>
                <input type='hidden' name='id' value='${user.id}'>
                <td>
                    <input type='submit' value='Обновить' class='submit'>
                </td>
            </form>
            <form action="${pageContext.request.contextPath}/list" method="post">
                <input type='hidden' name='action' value='delete'>
                <input type='hidden' name='id' value='${user.id}'>
                <input type='hidden' name='image' value='${user.photoId}'>
                <td>
                    <input type='submit' value='Удалить' class='submit'>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
<h1 style="text-align:center"><a href="${pageContext.request.contextPath}/create"
                                 style='text-decoration:none; color:orange'>Создать
    нового
    пользователя</a></h1>
</body>
</html>

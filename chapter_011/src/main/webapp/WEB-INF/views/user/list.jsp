<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<table cellpadding="5" width="100%" border="1" style="margin-bottom: 10px;">
    <tr style="text-align: center; background-color: coral">
        <td>Id:</td>
        <td>Имя:</td>
        <td>Логин:</td>
        <td>Почта:</td>
        <td>Роль:</td>
        <td>Фото:</td>
        <td>Скачать фото:</td>
        <td>Дата создания:</td>
        <td>Обновить</td>
        <td>Удалить</td>
    </tr>
    <jsp:useBean id="userList" scope="request" type="java.util.List"/>
    <c:forEach items="${userList}" var="user">
        <tr style="text-align: center; background-color: darkseagreen">
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
                    ${user.roleName}
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
                <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <form action="${pageContext.request.contextPath}/edit" method="get">
                <input type='hidden' name='action' value='update'>
                <input type='hidden' name='id' value='${user.id}'>
                <td>
                    <input style="background-color: orange" type='submit' value='Обновить' class='submit'>
                </td>
            </form>
            <form action="${pageContext.request.contextPath}/list" method="post">
                <input type='hidden' name='action' value='delete'>
                <input type='hidden' name='id' value='${user.id}'>
                <input type='hidden' name='image' value='${user.photoId}'>
                <td>
                    <input style="background-color: red" type='submit' value='Удалить' class='submit'>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
<div style="width:15%; margin:auto; display:flex; justify-content:space-around">
    <form action="${pageContext.request.contextPath}/create" method="get">
        <input style="background-color: orange" type='submit' value='Создать нового пользователя' class='submit'>
    </form>
    <form action="${pageContext.request.contextPath}/sing-out" method="get">
        <input style="margin-left: 20px; background-color: orange" type='submit' value='Выйти' class='submit'>
    </form>
    <form action="${pageContext.request.contextPath}/role" method="get">
        <input style="margin-left: 20px; background-color: orange" type='submit' value='Список ролей' class='submit'>
    </form>
</div>
</body>
</html>

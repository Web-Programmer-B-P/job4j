<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница пользователя</title>
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
    </tr>
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
            <fmt:formatDate value="${dateValue}" pattern="dd-MM-yyyy HH:mm:ss"/>
        </td>
        <form action="${pageContext.request.contextPath}/update_user" method="get">
            <input type='hidden' name='action' value='update'>
            <input type='hidden' name='id' value='${user.id}'>
            <td>
                <input style="background-color: orange" type='submit' value='Обновить' class='submit'>
            </td>
        </form>
    </tr>
</table>
<div style="width:15%; margin:auto; display:flex; justify-content:space-around">
    <form action="${pageContext.request.contextPath}/update_file_user" method="get">
        <input style="margin-left: 20px; background-color: orange" type='submit' value='Заменить Фото' class='submit'>
        <input type='hidden' name='id' value='${user.id}'>
    </form>
    <form action="${pageContext.request.contextPath}/sing-out" method="get">
        <input style="margin-left: 20px; background-color: orange" type='submit' value='Выйти' class='submit'>
    </form>
</div>
</body>
</html>

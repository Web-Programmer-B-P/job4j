<%@ page import="java.util.List" %>
<%@ page import="ru.job4j.servlets.crud.model.User" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: proger
  Date: 31.01.2020
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table cellpadding="5" width="100%" border="1">
    <tr>
        <td>Id:</td>
        <td>Имя</td>
        <td>Логин:</td>
        <td>Почта:</td>
        <td>Дата создания:</td>
        <td>Обновить</td>
        <td>Удалить</td>
    </tr>
    <%
        List<User> list = (List<User>) request.getAttribute("userList");
        for (User user : list) {
    %>
    <tr>
        <td>
            <%=user.getId()%>
        </td>
        <td>
            <%=user.getName()%>
        </td>
        <td>
            <%=user.getLogin()%>
        </td>
        <td>
            <%=user.getEmail()%>
        </td>
        <td>
            <%=new Date(user.getCreateDate())%>
        </td>
        <form action="<%=request.getContextPath()%>/edit" method="get">
            <input type='hidden' name='action' value='update'>
            <input type='hidden' name='id' value='<%=user.getId()%>'>
            <td>
                <input type='submit' value='Обновить' class='submit'>
            </td>
        </form>
        <form action="<%=request.getContextPath()%>/list" method="post">
            <input type='hidden' name='action' value='delete'>
            <input type='hidden' name='id' value='<%=user.getId()%>'>
            <td>
                <input type='submit' value='Удалить' class='submit'>
            </td>
        </form>
    </tr>
    <% } %>
</table>
<h1 style="text-align:center"><a href="<%=request.getContextPath()%>/create" style='text-decoration:none; color:orange'>Создать
    нового
    пользователя</a></h1>
</body>
</html>

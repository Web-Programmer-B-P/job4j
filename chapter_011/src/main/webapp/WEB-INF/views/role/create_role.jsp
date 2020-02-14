<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создать роль</title>
</head>
<body>
<div style='text-align:center;'>
    <h1>Страница создания пользователя</h1>
    <form action="${pageContext.request.contextPath}/role" method="post">
        <p>
            <strong>Наименование роли: </strong>
            <input name='name' placeholder='Наименование'>
        </p>
        <td>
            <input type='hidden' name='action' value='create'>
            <input type='submit' value='Создать роль' class='submit'>
        </td>
    </form>
</div>
</body>
</html>

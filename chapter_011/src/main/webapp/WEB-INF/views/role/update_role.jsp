<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница обновления роли</title>
</head>
<body>
<div style='text-align:center;'>
    <h1>Страница обновления роли</h1>
    <form action="${pageContext.request.contextPath}/role" method="post">
        <p>
            <strong>Наименование: </strong>
            <input name='name' placeholder='Наименование' value='${role.role}'>
        </p>
        <input type='hidden' name='action' value='update'>
        <input type='hidden' name='id' value='${role.id}'>
        <td>
            <input type='submit' value='Обновить' class='submit'>
        </td>
    </form>
</div>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница ролей</title>
</head>
<body>
<c:if test="${warning != ''}">
    <p style="background-color: orange">${warning}</p>
</c:if>
<div>
    <table cellpadding="5" width="100%" border="1" style="margin-bottom: 10px;">
        <tr>
            <td>Id:</td>
            <td>Наименование:</td>
            <td>Обновить</td>
        </tr>
        <jsp:useBean id="roles" scope="request" type="java.util.List"/>
        <c:forEach items="${roles}" var="role">
            <tr style="text-align: center">
                <td>
                        ${role.id}
                </td>
                <td>
                        ${role.role}
                </td>
                <form action="${pageContext.request.contextPath}/edit_role" method="get">
                    <input type='hidden' name='action' value='update'>
                    <input type='hidden' name='id' value='${role.id}'>
                    <td>
                        <input style="background-color: orange" type='submit' value='Обновить' class='submit'>
                    </td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="width: 20%; margin: auto; display: flex; justify-content: space-around">
    <form action="${pageContext.request.contextPath}/create_role" method="get">
        <div style="width: 20%; margin: auto">
            <input style="background-color: greenyellow; height: 30px; border: 1px solid #242d17;"
                   type='submit' value='Добавить роль' class='submit'>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/list" method="get">
        <div style="width: 20%; margin: auto">
            <input style="background-color: greenyellow; height: 30px; border: 1px solid #242d17;"
                   type='submit' value='Вернутся на главную' class='submit'>
        </div>
    </form>
</div>
</body>
</html>

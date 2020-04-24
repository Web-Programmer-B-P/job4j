<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>Список заявлений</title>
    <link href='<spring:url value="/resources/common.css"/>' rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body style="font-size: 0">
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<div class="container">
    <div id="header">
        <h2>Список заявлений</h2>
    </div>
    <table class="table table-striped" style="margin-top: 40px">
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Описание</th>
            <th>Адрес</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${accidentList}">
            <tr>
                <td><c:out value="${list.name}"/></td>
                <td><c:out value="${list.description}"/></td>
                <td><c:out value="${list.address}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
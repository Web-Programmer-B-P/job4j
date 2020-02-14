<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Замена фото</title>
</head>
<body>
<div style="width:15%; margin:auto; display:flex; justify-content:space-around">
    <form action="${pageContext.request.contextPath}/update_user" method="post">
    <p>
        <strong>Имя файла: </strong>
        <input name='image' placeholder='Это поле заполняется автоматически' value="${image}">
        <input type='hidden' name='action' value='image_update'>
    <input type='hidden' name='id' value='${id}'>
    </p>
        <input type='submit' value='Сохранить Фото' class='submit'>
    </form>
</div>

<div style="text-align: center;">
    <form action="${pageContext.request.contextPath}/update_file_user" method="post" enctype="multipart/form-data">
        <div class="checkbox">
            <input type="file" name="file">
        </div>
        <button type="submit" class='submit'>Закрепить файл за пользователем</button>
    </form>
</div>
</body>
</html>

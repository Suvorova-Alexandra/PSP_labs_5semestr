<%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 27.11.2020
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Читатель</title>
</head>
<body>
<div>
    <div>
        <div>
            <h2>Заявка на книгу:</h2>
        </div>
        <div>
            <form method="post">
                <div>
                    <label>Введите имя автора </label></br>
                    <input type="text" name="name">
                </div>

                <div>
                    <label>Введите название книги</label></br>
                    <input type="text" name="title">
                </div>

                <input type="submit" name="send" value="Отправить заявку">

            </form>
        </div>
    </div>

</div>
</body>
</html>

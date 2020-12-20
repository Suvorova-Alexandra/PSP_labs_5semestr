<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 09.11.2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<div>
    <div>
        <div>
            <div>
                <h2>Results</h2>
            </div>
            <form method="post">
                <label>Введите имя каталога(файла):
                    <input type="text" name="title1"><br/>
                </label>
                <button type="submit" name="form" value="form1">Просмотр</button>
            </form>
            <%
                ArrayList<String> resList = (ArrayList<String>) request.getAttribute("Results");
                ArrayList<String> count = (ArrayList<String>) request.getAttribute("Count");
                ArrayList<Float> memory = (ArrayList<Float>) request.getAttribute("Memory");
                ArrayList<String> deleteString = (ArrayList<String>) request.getAttribute("Delete");

                if (deleteString != null && !deleteString.isEmpty()) {
                    out.println("Delete State: " + deleteString.get(0));
                }
                if (resList != null && !resList.isEmpty()) {
                    out.println("<ui>");
                    int k = 0;
                    for (String s : resList) {
                        out.println("<li>" + s + "</li>");

                        out.println("Количество файлов: " + count.get(k));
                        out.println("</br>");
                        out.println("Память: " + memory.get(k));
                        k++;
                    }
                    out.println("</ui>");
                } else out.println("<p>There are no results yet!</p>");
                //
            %><br/>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>

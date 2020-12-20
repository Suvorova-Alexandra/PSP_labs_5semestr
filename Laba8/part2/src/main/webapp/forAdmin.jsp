<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Mi
  Date: 29.11.2020
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Администратор</title>
</head>
<body>
<div>
    <div>
        <div>
            <form method="post">
            <%
                ArrayList<String[]> resList = (ArrayList<String[]>) request.getAttribute("results");
                response.setContentType("text/html; charset=UTF8");
                if(resList != null && !resList.isEmpty()){
                    int k = 0;
                    for(String[] res: resList){
                        out.println("Заявка от: " + res[0]);
                        out.println("Автор книги: "+res[1]);
                        out.println("Название книги: "+res[2]);
                        out.print("<br/><label>Ответ на заявку:</label>" +
                                "                        <label><input type='radio' name=\"re"+k+"\" value=\"Yes\" checked>Yes<br/></label>" +
                                "                    <label><input type='radio' name=\"re"+k+"\" value=\"No\">No<br/></label>");
                        out.print("<br/> <input type='submit' name=\"pass"+k+"\" value=\"Отправить ответ\"><br/>");
                        out.println("_________________________________________________________________________________<br/>");
                        k++;
                    }
                }else out.println("<p>Заявок еще нет!</p>");

            %><br/>
            </form>
        </div>
    </div>

    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>

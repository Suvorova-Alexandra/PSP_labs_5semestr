<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26.11.2020
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add File</title>
</head>
<body>
<div>
    <div>
        <h2>Properties:</h2>
    </div>
    <div>
        <form method="post">
            <label>Enter name of catalog:
                <input type="text" name="title"><br/>
            </label>
            <label>Enter name of parent catalog:
                <input type="text" name="parent"><br/>
            </label>
            <label>Enter memory:
                <input type="text" name="memory"><br/>
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>

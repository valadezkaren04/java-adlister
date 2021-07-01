<%--
  Created by IntelliJ IDEA.
  User: alfredovaladez
  Date: 7/1/21
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <h1>Hello, ${name}</h1>

    <form action="/hello" method="post">
        <label for="name">Enter Name:</label>
        <input type="text" name="name" id="name">
        <input type="submit">
    </form>

<%--Redeploy vs Restart--%>

<%--Redeploy: reset the static content in our app. Updates made will redeploy ; refresh the assets --%>
<%--Restarts: restarts the servlet itself ; safests update ; if made changes in Java folder--%>
</body>
</html>

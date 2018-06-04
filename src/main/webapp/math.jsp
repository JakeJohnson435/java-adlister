<%--
  Created by IntelliJ IDEA.
  User: jake
  Date: 6/1/18
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Enter two numbers that you want to multiply</p>
<form method="POST" action="calculator">
    <p>
        First Number <input type="number" name="x" size="50" value="0"autofocus required>
    </p>
    <p>
        Second Number <input type="number" name="y" size="50" value="0"autofocus required>
    </p>
    <p>
        <input type="submit" value="Multiply" name="operator">
    </p>
    <input type="submit" value="Add" name="operator">
</form>

</body>
</html>

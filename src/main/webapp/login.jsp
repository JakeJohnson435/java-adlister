<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
    <%@ include file="partials/stylelinks.jsp" %>
    <%@ include file="partials/navbar.jsp" %>
</head>
<body>
<div class="container" style="width:25%;">
    <div class="row">
        <form action="login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
                <p>${message}</p>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>
</div>
<%@ include file="partials/scripts.jsp"%>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String username = request.getParameter("username"); %>
<html>
<head>
    <title>Profile</title>
    <%@ include file="partials/stylelinks.jsp" %>
    <%@ include file="partials/navbar.jsp" %>
</head>
<body>
<h3>Welcome back <%= username %></h3>

</body>
</html>

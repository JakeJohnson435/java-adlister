<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "Adlister Home" %></title>
    <%@ include file="partials/stylelinks.jsp" %>
    <%@ include file="partials/navbar.jsp" %>
</head>
<body>
    <c:if test="true">
        <h1>Adlister!</h1>
    </c:if>
    <c:if test="false">
        <h1>single letter variable names are good</h1>
    </c:if>
</body>
</html>

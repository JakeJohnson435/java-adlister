<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gregslist</title>
    <%@ include file="/partials/stylelinks.jsp" %>
</head>
<body>
<%@ include file="/partials/navbar.jsp" %>
<h1>Viewing All Ads</h1>
<div class="container">
    <c:forEach var="ad" items="${ads}">
        <div class="ads col-md-5">
            <div>
                <h3>${ad.title}</h3>
                <p>${ad.description}</p>
            </div>
        </div>
    </c:forEach>
</div>
<%@ include file="/partials/scripts.jsp"%>
</body>
</html>

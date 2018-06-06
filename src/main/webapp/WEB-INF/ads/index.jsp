<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gregslist</title>
    <%@ include file="/WEB-INF/partials/stylelinks.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>
<h1>Viewing All Listings</h1>
<form action="/ads/create" method="GET">
    <button type="submit" class="create">Create a Listing</button>
</form>
<br>
<div class="container adContainer">

    <c:forEach var="ad" items="${ads}">
        <div class="ads col-md-5">
            <div>
                <h3>${ad.title}</h3>
                <p>${ad.description}</p>
                <form action="delete" method="post">
                    <button name="deleteId" class="delete" value="${ad.id}">x</button>
                </form>
            </div>
        </div>
    </c:forEach>
</div>
<%@ include file="/WEB-INF/partials/scripts.jsp"%>
</body>
</html>

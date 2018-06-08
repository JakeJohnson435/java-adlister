<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@ include file="/WEB-INF/partials/stylelinks.jsp" %>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>

        <h1>Welcome back, ${sessionScope.username}!</h1>

        <h4 style="clear: both;">Here are your posts.</h4>
        <div class="container adContainer col-md-12">
            <c:forEach var="ad" items="${ads}">
                <div class="ads col-md-5">
                    <div class="adCard">
                        <h3 style="float: left;">${ad.title}</h3>
                        <form action="delete" method="post">
                            <button name="deleteId" class="delete" value="${ad.id}" style="background-color: red; padding: 5px 5px; float: right;"></button>
                        </form>
                        <p class="adDesc">${ad.description}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</body>
</html>

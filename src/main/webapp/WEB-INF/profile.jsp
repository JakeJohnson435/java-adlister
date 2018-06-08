<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%@ include file="/WEB-INF/partials/stylelinks.jsp" %>
<%@ include file="/WEB-INF/partials/navbar.jsp" %>

    <div class="container">
        <h1>Welcome back, ${sessionScope.username}!</h1>
    </div>

</body>
</html>

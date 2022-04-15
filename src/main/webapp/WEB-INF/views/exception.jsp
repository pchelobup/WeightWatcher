<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
</head>
<body>

<c:choose>
    <c:when test="${auth==true}">
        <jsp:include page="section/navigation.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="section/navigationSingIn.jsp"/>
    </c:otherwise>
</c:choose>

<div class="container">
    <div class="row">
        <div class="col-12">
            <c:choose>
                <c:when test="${status.equals('404')}">
                    This page does not exist
                </c:when>
                <c:otherwise>
                    Something went wrong
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>


</body>
</html>

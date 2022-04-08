<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
</head>
<body>
<jsp:include page="section/navigation.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <a class="btn btn-primary" href="/add" role="button">Add +</a>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Weight</th>
                    <th scope="col">Date</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${notations}" var="notation">
                    <tr>
                        <jsp:useBean id="notation" class="ru.alina.model.Notation" scope="request"/>
                        <td>${notation.weight}</td>
                        <td>${notation.added}</td>
                        <td><a href="${pageContext.request.contextPath}/edit?id=${notation.id}">Edit</a></td>
                        <td><a href="${pageContext.request.contextPath}/delete?id=${notation.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>

        </div>
    </div>
</div>
</body>
</html>

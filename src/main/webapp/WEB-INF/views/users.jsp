<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
</head>
<body>
<jsp:include page="section/navigationAdmin.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">email</th>
                    <th scope="col">registered</th>
                    <th scope="col">status</th>
                    <th scope="col">role</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.id()}</td>
                        <td>${user.email}</td>
                        <td>${user.registered}</td>
                        <td>${user.status}</td>
                        <td>${user.roles}</td>
                        <td><a href="${pageContext.request.contextPath}/admin/edit?id=${user.id}">edit</a></td>
                        <td><a href="${pageContext.request.contextPath}/admin/delete?id=${user.id}">delete</a></td>
                    </tr>
                </c:forEach>
                <tbody>
                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>

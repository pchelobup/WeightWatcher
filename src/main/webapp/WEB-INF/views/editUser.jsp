<%@ page import="ru.alina.model.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
</head>
<body>
<jsp:include page="section/navigationAdmin.jsp"/>
<a href="${pageContext.request.contextPath}/admin/users" class="back-link"><--- BACK</a>
<div class="container">
    <div class="row">
        <div class="col-12">

            <form method="post" action="${pageContext.request.contextPath}/admin/edit">
                <div class="form-group">
                    <input type="hidden" name="id" value="${user.id}">
                    <div class="form-qw">
                        <label for="email" class="col-form-label form-qw-header">Email</label>
                        <input type="email" min="100" class="form-control" id="email" name="email"
                               value="${user.email}">
                    </div>

                    <div class="form-qw">
                        <span class="form-qw-header">Status</span>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="active" value="active"
                            <c:if test="${user.status.name().equals('ACTIVE')}"> checked </c:if> >
                            <label class="form-check-label" for="active">
                                Active
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="not-active"
                                   value="not_active"
                            <c:if test="${user.status.name().equals('NOT_ACTIVE')}"> checked </c:if> >
                            <label class="form-check-label" for="not-active">
                                Not active
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="status" id="deleted" value="deleted"
                            <c:if test="${user.status.name().equals('DELETED')}"> checked </c:if> >
                            <label class="form-check-label" for="deleted">
                                Deleted
                            </label>
                        </div>
                    </div>

                    <div class="form-qw">
                        <span class="form-qw-header">Role</span>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="admin" id="admin" name="role"
                            <c:if test="${user.roles.contains(Role.ADMIN)}"> checked </c:if> >
                            <label class="form-check-label" for="admin">
                                Admin
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="user" id="user" name="role"
                            <c:if test="${user.roles.contains(Role.USER)}"> checked </c:if> >
                            <label class="form-check-label" for="user">
                                User
                            </label>
                        </div>
                    </div>
                </div>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Ok</button>

            </form>
        </div>
    </div>
</div>
</body>
</html>

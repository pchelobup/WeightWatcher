<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp" />
</head>
<body>
    <jsp:include page="section/navigation.jsp" />
    <div class="container">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <jsp:useBean id="notation" class="ru.alina.model.Notation" scope="request" />
                <form method="post" action="${pageContext.request.contextPath}/edit">
                    <input type="hidden" name="id" value="${notation.id}">
                    <div class="form-group">
                        <label for="weight" class="col-form-label">Weight</label>
                        <input type="number" step="0.01" min="0" class="form-control" id="weight" name="weight"
                               value="${notation.weight}">
                    </div>
                    <div class="form-group last-form-group">
                        <label for="added" class="col-form-label">Weight</label>
                        <input type="date" class="form-control" id="added" name="added" autocomplete="off"
                               value="${notation.added}">
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Ok</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

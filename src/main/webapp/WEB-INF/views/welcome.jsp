<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <div>
            <form class="exit" method="post" action="${pageContext.request.contextPath}/logout">
                <button type="submit" class="btn-no-style nav-link active">exit </button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-12">
            hello test
        </div>
    </div>
</div>

</body>
</html>

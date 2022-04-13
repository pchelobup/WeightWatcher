<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="section/navigationSingIn.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-12">
            <form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
                <h2 class="form-signin-heading">Sing In</h2>
                <p>
                    <label for="username">Email</label>
                    <input type="email" id="username" name="username" class="form-control" placeholder="Email"
                           required>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                           required>
                </p>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ok</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>

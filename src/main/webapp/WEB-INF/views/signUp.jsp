<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp"/>
</head>
<body>
<jsp:include page="section/navigationSignUp.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-12">
            <form class="form-signin" method="post" action="${pageContext.request.contextPath}/registration">
                <h2 class="form-signin-heading">Sing Up</h2>
                <p>
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Email"
                           required>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                           required>
                </p>
                <p>
                    <label for="password-confirm">Repeat password</label>
                    <input type="password" id="password-confirm" name="password-confirm" class="form-control"
                           placeholder="Repeat password"
                           required>
                </p>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Ok</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>

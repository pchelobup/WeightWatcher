<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/aboutAuth">WeightWatcher</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        </div>
        <div>
            <form class="exit" method="post" action="${pageContext.request.contextPath}/logout">
                <button type="submit" class="btn-no-style nav-link active">exit</button>
            </form>
        </div>
    </div>
</nav>


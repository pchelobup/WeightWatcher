<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">WeightWatcher</a>
        <div>
            <form class="exit" method="post" action="${pageContext.request.contextPath}/logout">
                <button type="submit" class="btn-no-style nav-link active">exit</button>
            </form>
        </div>
    </div>
</nav>


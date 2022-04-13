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
        <div class="col-12">

            <c:set scope="request" var="profile" value="${profileTo}" />

            <div> <h5 class="header-inline">Your goal</h5> : ${profile.desiredWeight}</div>
            <hr/>
            <p>Calories for slow weight loss: ${profile.slowGoal}</p>
            <p >Calories for average weight loss: ${profile.middleGoal}</p>
            <p>Calories for fast weight loss: ${profile.fastGoal}</p>
            <hr/>

            <div> <a href="${pageContext.request.contextPath}/editProfile"><img src="${pageContext.request.contextPath}/resources/img/edit.png" class="icon" data-title="Софийский собор"> </a><h4 class="header-inline">Your data </h4></div>
            <p>Gender: ${profile.gender.name()}</p>
            <p>Height: ${profile.height}</p>
            <p>Age: ${profile.age}</p>
            <p>Activity: ${profile.activity.name()}</p>
            <p>Weight now: ${profile.startWeight}</p>
            <p>Desire Weight: ${profile.desiredWeight}</p>
        </div>
    </div>
</div>
</body>
</html>

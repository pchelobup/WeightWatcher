<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="section/head.jsp" />
</head>
<body>
    <jsp:include page="section/navigation.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <jsp:useBean id="profile" class="ru.alina.model.Profile" scope="request" />
            <form action="${pageContext.request.contextPath}/profileForm" method="post">
                <div class="form-group">
                    <div class="profile-qw">
                        <span>Gender</span>

                        <div class="form-check">

                            <input class="form-check-input" type="radio" name="gender" id="male" value="male" <c:if test="${profile.gender.name().equals('MALE')}"> checked </c:if> >
                            <label class="form-check-label" for="male">
                                Male
                            </label>
                        </div>

                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" id="female" value="female" <c:if test="${profile.gender.name().equals('FEMALE')}"> checked </c:if>>
                        <label class="form-check-label" for="female">
                            Female
                        </label>
                    </div>

                    <div class="profile-qw">
                        <label for="height" class="col-form-label">Height</label>
                        <input type="number" min="100" max="250" step="1" class="form-control" id="height" name="height" value="${profile.height}">
                    </div>

                    <div class="profile-qw">
                        <label for="age" class="col-form-label">Age</label>
                        <input type="number" min="16" max="120" step="1" class="form-control" id="age" name="age" value="${profile.age}">
                    </div>

                    <div class="profile-qw">
                        <span>Activity</span>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="activity" id="min" value="min" <c:if test="${profile.activity.name().equals('MIN')}"> checked </c:if>    >
                            <label class="form-check-label" for="min">
                                Minimal(no physical activity and sedentary work)
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="activity" id="weak" value="weak" <c:if test="${profile.activity.name().equals('WEAK')}"> checked </c:if> >
                            <label class="form-check-label" for="weak">
                                Weak(light jogging or light exercise 1-3 times a week or high daily activity
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="activity" id="middle" value="middle"  <c:if test="${profile.activity.name().equals('MIDDLE')}"> checked </c:if> >
                            <label class="form-check-label" for="middle">
                                Middle(do moderate-intensity sports 3-5 times a week)
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="activity" id="great" value="great" <c:if test="${profile.activity.name().equals('GREAT')}"> checked </c:if> >
                            <label class="form-check-label" for="great">
                                Great(fully train 6-7 times a week)
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="activity" id="max" value="max" <c:if test="${profile.activity.name().equals('MAX')}"> checked </c:if> >
                            <label class="form-check-label" for="male">
                                Extremely high(The job is physically demanding and you train 2 times a day)
                            </label>
                        </div>
                    </div>

                    <div class="profile-qw">
                        <label for="start-weight" class="col-form-label">Current weight</label>
                        <input type="number" step="0.01" min="0" class="form-control" id="start-weight" name="startWeight" value="${profile.startWeight}">
                    </div>

                    <div class="profile-qw">
                        <label for="desired-weight" class="col-form-label">Desired Weight</label>
                        <input type="number" step="0.01" min="0" class="form-control" id="desired-weight" name="desiredWeight" value="${profile.desiredWeight}">
                    </div>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Ok</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

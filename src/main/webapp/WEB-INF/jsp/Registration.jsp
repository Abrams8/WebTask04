<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>

    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.name" var="name"/>
    <fmt:message bundle="${loc}" key="local.surname" var="surname"/>
    <fmt:message bundle="${loc}" key="local.phone_number" var="phone_number"/>
    <fmt:message bundle="${loc}" key="local.passport_number" var="passport_number"/>
    <fmt:message bundle="${loc}" key="local.mail" var="mail"/>
    <fmt:message bundle="${loc}" key="local.age" var="age"/>
    <fmt:message bundle="${loc}" key="local.button.go_to_main_page" var="go_to_main"/>
    <fmt:message bundle="${loc}" key="local.button.registration" var="button_registration"/>
    <fmt:message bundle="${loc}" key="local.button.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.button.en" var="en_button"/>

    <link rel="stylesheet" href="css/registrationStyle.css" type="text/css">

</head>
<style>
    label {
        width: 120px;
        display: inline-block;
    }
</style>
<body>

<c:set var="errorMessage" scope="page" value="${requestScope.get('errorMessage')}"/>
<c:if test="${not empty errorMessage}">
    <c:out value="${errorMessage}"/>
</c:if>

<div class="header_top">

    <div class="welcome_message">
        <h1>${button_registration}</h1>
    </div>

    <div class="language_change">
        <form action="MyController?command=CHANGE_LOCALE" method="post">
            <input type="hidden" name="local" value="ru"/>
            <input class="language-button" type="submit" value="${ru_button}"/>
        </form>

        <form action="MyController?command=CHANGE_LOCALE" method="post">
            <input type="hidden" name="local" value="en"/>
            <input class="language-button" type="submit" value="${en_button}"/>
        </form>
    </div>
</div>

<div class="main">

    <form class="login_forms" action="MyController" method="post">
        <input type="hidden" name="command" value="registration">
        <div class="labels">
            <label for="1">${login}:</label>
            <label for="2">${password}:</label>
            <label for="3">${name}:</label>
            <label for="4">${surname}:</label>
            <label for="5">${phone_number}:</label>
            <label for="6">${mail}:</label>
            <label for="7">${passport_number}:</label>
            <label for="8">${age}:</label>
        </div>

        <div class="inputs">
            <input id="1" type="text" name="login" value=""/>
            <br/>
            <input id="2" type="password" name="password" value=""/>
            <br/>
            <input id="3" type="text" name="name" value=""/>
            <br/>
            <input id="4" type="text" name="surname" value=""/>
            <br/>
            <input id="5" type="text" name="phoneNumber" value=""/>
            <br/>
            <input id="6" type="text" name="mail" value=""/>
            <br/>
            <input id="7" type="text" name="passportNumber" value=""/>
            <br/>
            <input id="8" type="text" name="age" value=""/>
        </div>

        <input type="submit" value="${button_registration}"></input>
    </form>

    <a href="MyController?command=GO_TO_MAIN_PAGE">${go_to_main}</a>


</div>
</body>
</html>

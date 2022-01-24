
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="by.epam.tr.task04.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logination</title>

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="local" var="loc"/>

    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.button.go_to_main_page" var="go_to_main"/>
    <fmt:message bundle="${loc}" key="local.button.logination" var="button_login"/>
    <fmt:message bundle="${loc}" key="local.button.registration" var="button_registration"/>
    <fmt:message bundle="${loc}" key="local.button.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.button.en" var="en_button"/>

    <link rel="stylesheet" href="css/loginationStyle.css" type="text/css">

</head>

<body>
<div class="header_top">

    <div class="welcome_message">
        <h1>${button_login}</h1>
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

<div class="header_top2">
    <div class="welcome_message">

        <c:if test="${not empty requestScope.errorMessage}" var="errorMessageRegistration">
            <h3 style="color: darkred"><c:out value="${requestScope.errorMessage}"/></h3>
        </c:if>

    </div>
</div>

<div class="main">

    <form class="login_forms" action="MyController" method="post">
        <input type="hidden" name="command" value="logination">
        <div class="labels">
            <label for="1">${login}:</label>
            <label for="2">${password}:</label>
        </div>

        <div class="inputs">
            <input id="1" type="text" name="login" value=""/>
            <input id="2" type="password" name="password" value=""/>
        </div>

        <input type="submit" value="${button_login}"></input>
    </form>


    <a href="MyController?command=GO_TO_REGISTRATION_PAGE">${button_registration}</a>
    <a href="MyController?command=GO_TO_MAIN_PAGE">${go_to_main}</a>


</div>

</body>
</html>

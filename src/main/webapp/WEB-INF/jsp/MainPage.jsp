
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Main page</title>


    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="local" var="loc"/>

    <fmt:message bundle="${loc}" key="local.button.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.button.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.registration" var="registration"/>
    <fmt:message bundle="${loc}" key="local.button.logination" var="login_in"/>
    <fmt:message bundle="${loc}" key="local.rent_car" var="rent_car"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.all_cars" var="all_cars"/>
    <fmt:message bundle="${loc}" key="local.button.go_to_main_page" var="go_to_main_page"/>

    <link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

<div class="header_top">
    <div class="welcome_message">
        <c:if test="${not empty login and role eq 'Client'}" var="isClient">
            <h1><c:out value="Hello, Client" /></h1>
        </c:if>

        <c:if test="${not empty login and role eq 'Admin'}" var = "isAdmin">
            <h1><c:out value="Hello, Admin" /></h1>
        </c:if>
    </div>

    <div class="language_change">
        <form action="MyController?command=CHANGE_LOCALE" method="get">
            <input type="hidden" name="command" value="CHANGE_LOCALE">
            <input type="hidden" name="local" value="ru"/>
            <input class="language-button" type="submit"  value="${ru_button}"/>
        </form>

        <form action="MyController?command=CHANGE_LOCALE" method="post">
            <input type="hidden" name="local" value="en"/>
            <input class="language-button" type="submit"  value="${en_button}"/>
        </form>
    </div>
</div>

<div class="header_line">
    <c:if test="${not empty login}" var="isLoginIn">
        <c:out value="ClienOrAdmin" />

        <a href="MyController?command=LOG_OUT">Logout</a>
        <a href="MyController?command=GO_TO_ACCAUNT_INFORMATION_PAGE">Accaunt information</a>
        <a href="MyController?command=GO_TO_FREE_CARS_PAGE">All cars</a>
        <a href="MyController?command=GO_TO_MY_ORDERS_PAGE">My orders</a>
    </c:if>

    <div class="header_buttons">
        <a href="MyController?command=GO_TO_FREE_CARS_PAGE">${rent_car}</a>
        <a href="">${all_cars}</a>
        <a href="">${contacts}</a>
    </div>

    <c:if test="${empty role}" var = "isUnknownUser">
        <c:out value="UnknownUser" />

        <div class="logination_registration">
            <a href="MyController?command=GO_TO_LOGINATION_PAGE" >${login_in}</a>
            <a href="MyController?command=GO_TO_REGISTRATION_PAGE">${registration}</a>
        </div>

    </c:if>

</div>
</body>
</html>
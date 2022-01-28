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

    <fmt:message bundle="${loc}" key="local.button.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.button.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.registration" var="registration"/>
    <fmt:message bundle="${loc}" key="local.button.logination" var="login_in"/>
    <fmt:message bundle="${loc}" key="local.rent_car" var="rent_car"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.all_cars" var="all_cars"/>
    <fmt:message bundle="${loc}" key="local.button.go_to_main_page" var="go_to_main_page"/>
    <fmt:message bundle="${loc}" key="local.button.home_page" var="home_page"/>
    <fmt:message bundle="${loc}" key="local.button.rent_terms" var="rent_terms"/>

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
    <fmt:message bundle="${loc}" key="local.message.registration.errorMessageRegistration"
                 var="errorMessageRegistration"/>

    <fmt:message bundle="${loc}" key="local.button.get_all_confirmed_orders" var="get_all_confirmed_orders"/>
    <fmt:message bundle="${loc}" key="local.button.get_all_unconfirmed_orders" var="get_all_unconfirmed_orders"/>
    <fmt:message bundle="${loc}" key="local.button.get_all_closed_orders" var="get_all_closed_orders"/>
    <fmt:message bundle="${loc}" key="local.button.close" var="close"/>
    <fmt:message bundle="${loc}" key="local.button.confirm" var="confirm"/>
    <fmt:message bundle="${loc}" key="local.button.get_all_users" var="get_all_users"/>
    <fmt:message bundle="${loc}" key="local.button.get_black_list" var="get_black_list"/>
    <fmt:message bundle="${loc}" key="local.button.to_black_list" var="to_black_list"/>
    <fmt:message bundle="${loc}" key="local.button.delete" var="delete"/>
    <fmt:message bundle="${loc}" key="local.button.admin_orders" var="admin_orders"/>
    <fmt:message bundle="${loc}" key="local.button.admin_users" var="admin_users"/>
    <fmt:message bundle="${loc}" key="local.button.admin_cars" var="admin_cars"/>
    <fmt:message bundle="${loc}" key="local.button.admin_pay" var="admin_pay"/>

    <link rel="stylesheet" href="css/registrationStyle.css" type="text/css">
    <link rel="stylesheet" href="css/styles.css" type="text/css">

</head>
<style>
    label {
        width: 120px;
        display: inline-block;
    }
</style>
<body>

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

<div class="header_line">

    <div class="header_buttons">
        <a href="MyController?command=GO_TO_MAIN_PAGE">${home_page}</a>
        <a href="MyController?command=GO_TO_FREE_CARS_PAGE">${rent_car}</a>
        <a href="">${rent_terms}</a>
        <a href="">${contacts}</a>

    </div>

    <c:if test="${empty role}" var="isUnknownUser">

        <div class="logination_registration">
            <a href="MyController?command=GO_TO_LOGINATION_PAGE">${login_in}</a>
            <a href="MyController?command=GO_TO_REGISTRATION_PAGE">${registration}</a>
        </div>

    </c:if>
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
            <input id="2" type="password" name="password" value=""/>
            <input id="3" type="text" name="name" value=""/>
            <input id="4" type="text" name="surname" value=""/>
            <input id="5" type="text" name="phoneNumber" value=""/>
            <input id="6" type="text" name="mail" value=""/>
            <input id="7" type="text" name="passportNumber" value=""/>
            <input id="8" type="text" name="age" value=""/>
            <br>
            <input type="submit" value="${button_registration}"></input>
            <br>
        </div>
    </form>
</div>
</body>
</html>

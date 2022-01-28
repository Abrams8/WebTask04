
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Main page</title>


    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.user_id" var="user_id"/>
    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.old_or_new_password" var="old_or_new_password"/>
    <fmt:message bundle="${loc}" key="local.name" var="name"/>
    <fmt:message bundle="${loc}" key="local.surname" var="surname"/>
    <fmt:message bundle="${loc}" key="local.phone_number" var="phone_number"/>
    <fmt:message bundle="${loc}" key="local.passport_number" var="passport_number"/>
    <fmt:message bundle="${loc}" key="local.mail" var="mail"/>
    <fmt:message bundle="${loc}" key="local.age" var="age"/>
    <fmt:message bundle="${loc}" key="local.button.save_accaunt_info" var="save_accaunt_info"/>

    <fmt:message bundle="${loc}" key="local.button.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.button.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.button.registration" var="registration"/>
    <fmt:message bundle="${loc}" key="local.button.logination" var="login_in"/>
    <fmt:message bundle="${loc}" key="local.rent_car" var="rent_car"/>
    <fmt:message bundle="${loc}" key="local.contacts" var="contacts"/>
    <fmt:message bundle="${loc}" key="local.all_cars" var="all_cars"/>
    <fmt:message bundle="${loc}" key="local.button.go_to_main_page" var="go_to_main_page"/>

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

    <fmt:message bundle="${loc}" key="local.button.accaunt_information" var="accaunt_information"/>
    <fmt:message bundle="${loc}" key="local.button.my_orders" var="my_orders"/>
    <fmt:message bundle="${loc}" key="local.button.logout" var="logout"/>

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

    <link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

<div class="header_top">
    <div class="welcome_message">
        <c:if test="${not empty login and role eq 'Client'}" var="isClient">
            <h1><c:out value="Hello, ${sessionScope.login}" /></h1>
        </c:if>

        <c:if test="${not empty login and role eq 'Admin'}" var = "isAdmin">
            <h1><c:out value="Hello, ${sessionScope.login}" /></h1>
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

<div class="header_top2">
    <div class="welcome_message">

        <c:if test="${not empty requestScope.errorMessageChangeAccauntInfo}" >
            <h3 style="color: darkred"><c:out value="${requestScope.errorMessageChangeAccauntInfo}"/></h3>
        </c:if>

        <c:if test="${not empty requestScope.successMessageChangeAccauntInfo}">
            <h3 style="color: orange"><c:out value="${requestScope.successMessageChangeAccauntInfo}"/></h3>
        </c:if>

    </div>
</div>

<div class="header_line">

    <div class="header_buttons">
        <a href="MyController?command=GO_TO_MAIN_PAGE">${home_page}</a>
        <a href="MyController?command=GO_TO_FREE_CARS_PAGE">${rent_car}</a>
        <a href="">${rent_terms}</a>
        <a href="">${contacts}</a>

    </div>

    <c:if test="${empty role}" var = "isUnknownUser">

        <div class="logination_registration">
            <a href="MyController?command=GO_TO_LOGINATION_PAGE" >${login_in}</a>
            <a href="MyController?command=GO_TO_REGISTRATION_PAGE">${registration}</a>
        </div>

    </c:if>
</div>

<div class="user_buttons" >
    <c:if test="${not empty login and role eq 'Client'}" var="isLoginInUser">
        <br><hr style="width: 300px">
        <a href="MyController?command=GO_TO_ACCAUNT_INFORMATION_PAGE"><h3 style="color: white; margin: 10px">${accaunt_information} </h3></a><hr style="width: 300px">
        <a href="MyController?command=GO_TO_MY_ORDERS_PAGE"><h3 style="color: white; margin: 10px">${my_orders} </h3></a><hr style="width: 300px">
        <a href="MyController?command=LOG_OUT"><h3 style="color: white; margin: 10px">${logout} </h3></a><hr style="width: 300px">
    </c:if>

    <c:if test="${not empty login and role eq 'Admin'}" var="isLoginInAdmin">
        <br><hr style="width: 300px">
        <a href="MyController?command=GO_TO_ACCAUNT_INFORMATION_PAGE"><h3 style="color: white; margin: 10px">${accaunt_information} </h3></a><hr style="width: 300px">
        <a href="MyController?command=GO_TO_ADMIN_ORDERS_PAGE"><h3 style="color: white; margin: 10px">${admin_orders} </h3></a><hr style="width: 300px">
        <a href="MyController?command=GO_TO_ADMIN_USERS_PAGE"><h3 style="color: white; margin: 10px">${admin_users} </h3></a><hr style="width: 300px">
        <a href="MyController?command=GO_TO_ADMIN_CARS_PAGE"><h3 style="color: white; margin: 10px">${admin_cars} </h3></a><hr style="width: 300px">
        <a href="MyController?command=LOG_OUT"><h3 style="color: white; margin: 10px">${logout} </h3></a><hr style="width: 300px">
    </c:if>

</div>

<hr><hr>
<div align="center">
<form class="login_forms" action="MyController" method="post">
    <input type="hidden" name="command" value="SAVE_ACCAUNT_CHANGES">
    <div class="labels">
        <label for="1">${user_id}:</label> <input id="1" type="text" readonly name="userId" value="${user.id}"/><hr>
        <label for="2">${login}:</label> <input id="2" type="text" readonly name="login" value="${user.login}"/><hr>
        <label for="3">${passport_number}:</label> <input id="3" type="text" readonly name="passportNumber" value="${user.pasportNumber}"/><hr>
        <label for="4">${name}:</label> <input id="4" type="text" name="name" value="${user.name}"/><hr>
        <label for="5">${surname}:</label> <input id="5" type="text" name="surname" value="${user.surname}"/><hr>
        <label for="6">${phone_number}:</label> <input id="6" type="text" name="phoneNumber" value="${user.phoneNumber}"/><hr>
        <label for="7">${mail}:</label> <input id="7" type="text" name="mail" value="${user.mail}"/><hr>
        <label for="8">${age}:</label> <input id="8" type="text" name="age" value="${user.age}"/><hr>
        <label for="9">${password}:</label> <input id="9" type="password" name="password" value=""/><hr>

        <input type="submit" value="${save_accaunt_info}"></input>
    </div>


</form>
</div>
</body>
</html>


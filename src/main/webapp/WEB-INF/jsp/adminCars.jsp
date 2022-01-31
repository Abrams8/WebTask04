<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Main page</title>


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

    <fmt:message bundle="${loc}" key="local.button.get_all_cars" var="get_all_cars"/>
    <fmt:message bundle="${loc}" key="local.button.get_cars_in_repair" var="get_cars_in_repair"/>
    <fmt:message bundle="${loc}" key="local.button.update_car" var="update_car"/>
    <fmt:message bundle="${loc}" key="local.button.add_to_repair" var="add_to_repair"/>



    <link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

<div class="header_top">
    <div class="welcome_message">

        <c:if test="${not empty login and role eq 'Admin'}" var="isAdmin">
            <h1><c:out value="Hello, ${sessionScope.login}"/></h1>
        </c:if>
    </div>

    <div class="language_change">
        <form action="MyController?command=CHANGE_LOCALE" method="get">
            <input type="hidden" name="command" value="CHANGE_LOCALE">
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

</div>

<div class="user_buttons">

    <c:if test="${not empty login and role eq 'Admin'}" var="isLoginInAdmin">
        <br>
        <hr style="width: 300px">
        <a href="MyController?command=GET_ALL_CARS"><h3 style="color: white; margin: 10px">${get_all_cars} </h3></a>
        <hr style="width: 300px">
        <a href="MyController?command=GET_CARS_IN_REPAIR"><h3 style="color: white; margin: 10px">${get_cars_in_repair} </h3></a>
        <hr style="width: 300px">
        <a href="MyController?command=LOG_OUT"><h3 style="color: white; margin: 10px">${logout} </h3></a>
        <hr style="width: 300px">
    </c:if>
</div>

<div>

</div>
<c:if test="${not empty requestScope.allCars}">
    <div align="center">
        <table cols="13" border="1%" width="60%" cellpadding="10" bgcolor="#e6e6fa">
            <tr>
                <th>Car Id</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Transmission type</th>
                <th>Year</th>
                <th>Price</th>
                <th>Fuel type</th>
                <th>Body type</th>
            </tr>
            <c:forEach var="car" items="${requestScope.allCars}">
                <tr>
                        <td><c:out value="${car.carId}"/></td>
                        <td><c:out value="${car.brand}"/></td>
                        <td><c:out value="${car.model}"/></td>
                        <td><c:out value="${car.transmissionType}"/></td>
                        <td><c:out value="${car.yearOfIssue}"/></td>
                        <td><c:out value="${car.price}"/></td>
                        <td><c:out value="${car.fuelType}"/></td>
                        <td><c:out value="${car.bodyType}"/></td>
                    <form action="MyController" method="get">
                            <input type="hidden" name="command" value="DELETE_CAR">
                            <input type="hidden" name="carId" value="${car.carId}"/>
                            <td><input type="submit" value="${delete}"></td>
                    </form>
                    <form action="MyController" method="get">
                        <input type="hidden" name="command" value="UPDATE_CAR">
                        <input type="hidden" name="carId" value="${car.carId}"/>
                        <td><input type="submit" value="${update_car}"></td>
                    </form>

                    <td><input type="date" name="startDate" value="2021-01-25"
                               max="2025-01-01" min="2021-01-25"></td>
                    <td><input type="date" name="endDate" value="2021-01-26"
                               max="2025-01-01" min="2021-01-25"></td>
                    <form action="MyController" method="get">
                        <input type="hidden" name="command" value="ADD_TO_REPAIR">
                        <input type="hidden" name="carId" value="${car.carId}"/>
                        <td><input type="submit" value="${add_to_repair}"></td>
                    </form>
                    <hr>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<c:if test="${not empty requestScope.carsUnderRepair}">
    <div align="center">
        <table cols="11" border="1%" width="60%" cellpadding="5" bgcolor="#e6e6fa">
            <tr>
                <th>User id</th>
                <th>login</th>
                <th>pasportNumber</th>
                <th>name</th>
                <th>surname</th>
                <th>phoneNumber</th>
                <th>mail</th>
                <th></th>
            </tr>
            <c:forEach var="user" items="${requestScope.carsUnderRepair}">
                <tr>

                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.pasportNumber}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.surname}"/></td>
                    <td><c:out value="${user.phoneNumber}"/></td>
                    <td><c:out value="${user.mail}"/></td>
                    <form action="MyController" method="get">
                        <input type="hidden" name="command" value="DELETE_USER_FROM_BLACK_LIST">
                        <input type="hidden" name="userId" value="${user.id}"/>
                        <td><input type="submit" value="${delete}"></td>
                    </form>
                    <hr>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
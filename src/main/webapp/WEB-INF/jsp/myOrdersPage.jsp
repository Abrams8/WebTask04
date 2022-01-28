<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>My orders</title>


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
    <fmt:message bundle="${loc}" key="local.button.pay" var="pay"/>
    <fmt:message bundle="${loc}" key="local.button.orders_history" var="orders_history"/>


    <link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

<div class="header_top">
    <div class="welcome_message">
        <c:if test="${not empty login and role eq 'Client'}" var="isClient">
            <h1><c:out value="Hello, ${sessionScope.login}"/></h1>
        </c:if>

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

    <c:if test="${empty role}" var="isUnknownUser">

        <div class="logination_registration">
            <a href="MyController?command=GO_TO_LOGINATION_PAGE">${login_in}</a>
            <a href="MyController?command=GO_TO_REGISTRATION_PAGE">${registration}</a>
        </div>

    </c:if>
</div>

<div class="user_buttons">
    <c:if test="${not empty login}" var="isLoginIn">
        <br>
        <hr style="width: 300px">
        <a href="MyController?command=GO_TO_ACCAUNT_INFORMATION_PAGE"><h3
                style="color: white; margin: 10px">${accaunt_information} </h3></a>
        <hr style="width: 300px">
        <a href="MyController?command=GO_TO_MY_ORDERS_PAGE"><h3 style="color: white; margin: 10px">${my_orders} </h3>
        </a>
        <hr style="width: 300px">
        <a href="MyController?command=GO_TO_MY_ORDERS_HISTORY_PAGE"><h3
                style="color: white; margin: 10px">${orders_history} </h3>
        </a>
        <hr style="width: 300px">
        <a href="MyController?command=LOG_OUT"><h3 style="color: white; margin: 10px">${logout} </h3></a>
        <hr style="width: 300px">
    </c:if>

</div>
<c:if test="${not empty requestScope.myOrders}">
    <div align="center">
        <table cols="10" border="1%" width="80%" cellpadding="10" align="center" bgcolor="#e6e6fa">
            <tr>
                <th>orderId</th>
                <th>carId</th>
                <th>startDate</th>
                <th>endDate</th>
                <th>isConfirmed</th>
                <th>isPayed</th>
                <th>comments</th>
                <th>price</th>

            </tr>
            <c:forEach var="order" items="${requestScope.myOrders}">
                <tr>
                    <td><c:out value="${order.orderId}"/></td>
                    <td><c:out value="${order.carId}"/></td>
                    <td><c:out value="${order.startDate}"/></td>
                    <td><c:out value="${order.endDate}"/></td>
                    <td><c:out value="${order.isConfirmed}"/></td>
                    <td><c:out value="${order.isPayed}"/></td>
                    <td><c:out value="${order.comments}"/></td>
                    <td><c:out value="${order.orderPrice}"/></td>

                    <form action="MyController" method="get">
                        <input type="hidden" name="command" value="PAY_ORDER">
                        <input type="hidden" name="orderId" value="${order.orderId}"/>
                        <td><input type="submit" value="${pay}"></td>
                    </form>

                    <form action="MyController" method="get">
                        <input type="hidden" name="command" value="DELETE_ORDER">
                        <input type="hidden" name="carId" value="${order.carId}"/>
                        <input type="hidden" name="orderId" value="${order.orderId}"/>
                        <td><input type="submit" value="${delete}"></td>
                    </form>


                    <hr>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
<c:if test="${not empty requestScope.myHistoryOrders}">
    <div align="center">
        <table cols="7" border="1%" width="80%" cellpadding="10" align="center" bgcolor="#e6e6fa">
            <tr>
                <th>orderId</th>
                <th>carId</th>
                <th>startDate</th>
                <th>endDate</th>
                <th>isConfirmed</th>
                <th>isPayed</th>
                <th>comments</th>
                <th>price</th>

            </tr>
            <c:forEach var="order" items="${requestScope.myHistoryOrders}">
                <tr>
                    <td><c:out value="${order.orderId}"/></td>
                    <td><c:out value="${order.carId}"/></td>
                    <td><c:out value="${order.startDate}"/></td>
                    <td><c:out value="${order.endDate}"/></td>
                    <td><c:out value="${order.isConfirmed}"/></td>
                    <td><c:out value="${order.isPayed}"/></td>
                    <td><c:out value="${order.comments}"/></td>
                    <td><c:out value="${order.orderPrice}"/></td>

                    <hr>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
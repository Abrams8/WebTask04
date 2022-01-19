<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="errorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Welcome page</title>
    
    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="resources.local" var="loc" />

    <fmt:message bundle="${loc}" key="local.message" var="message" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>
    
</head>
<body>
<h1>Welcome page</h1>

<a href="MyController?command=GO_TO_LOGINATION_PAGE">Logination</a>
<br/>

<a href="MyController?command=GO_TO_REGISTRATION_PAGE">Registration</a>
<br/>

<a href="MyController?command=GO_TO_FREE_CARS_PAGE">FreeCars</a>
</body>
</html>

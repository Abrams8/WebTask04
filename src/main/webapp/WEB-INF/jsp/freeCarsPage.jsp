
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="errorPage.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>FreeCars</title>
</head>
<body>
<h1>- Free cars -</h1>
<table>
    <tr>
        <td>CarId</td>
        <td>Brand</td>
        <td>Model</td>
    </tr>
<c:forEach var="car" items="${requestScope.freeCars}">
    <tr>
        <td><c:out value="${car.carId}"/></td>
        <td><c:out value="${car.brand}"/></td>
        <td><c:out value="${car.model}"/></td>
    </tr>
</c:forEach>
</table>
</body>
</html>

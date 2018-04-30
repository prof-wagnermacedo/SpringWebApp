<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="list.cars"/></title>
    </head>
    <body>
        <h1><spring:message code="list.cars"/></h1>
        <c:forEach items="${carList}" var="car">
            <p>
                <c:url var="editUrl" value="/car/edit/${car.id}" />
                <c:url var="deleteUrl" value="/car/delete/${car.id}" />
                ${car.name}: $${car.price}
                <a href="${editUrl}"><spring:message code="list.edit"/></a>
                <a href="${deleteUrl}"><spring:message code="list.delete"/></a>
            </p>
        </c:forEach>
    </body>
</html>

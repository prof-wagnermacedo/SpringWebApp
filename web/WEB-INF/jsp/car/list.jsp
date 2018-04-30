<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros</title>
    </head>
    <body>
        <h1>Carros</h1>
        <c:forEach items="${carList}" var="car">
            <p>
                <c:url var="editUrl" value="/car/edit/${car.id}" />
                <c:url var="deleteUrl" value="/car/delete/${car.id}" />
                ${car.name}: $${car.price} <a href="${editUrl}">Editar</a> <a href="${deleteUrl}">Excluir</a>
            </p>
        </c:forEach>
    </body>
</html>

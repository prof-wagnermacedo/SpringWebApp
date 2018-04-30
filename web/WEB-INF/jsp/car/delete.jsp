<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="car.delete.confirm.title"/></title>
    </head>
    <body>
        <h1><spring:message code="car.delete.title"/></h1>
        <form method="post">
            <input type="hidden" value="${car.id}">
            <p><spring:message code="car.delete.phrase" arguments="${car.name}"/></p>
            <p><button><spring:message code="car.delete.button"/></button></p>
        </form>
    </body>
</html>

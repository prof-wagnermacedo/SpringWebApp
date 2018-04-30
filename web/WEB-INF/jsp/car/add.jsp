<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test="${car.id == null}">
        <spring:message var="title" code="car.form.title.add" />
    </c:when>
    <c:otherwise>
        <spring:message var="title" code="car.form.title.edit" />
    </c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <style>
            .error { color: red; }
        </style>
    </head>
    <body>
        <h1>${title}</h1>

        <form:form method="POST" modelAttribute="car">
            <form:hidden path="id" />
            <p>
                <spring:message code="car.form.name"/>: <br>
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </p>
            <p>
                <spring:message code="car.form.price"/>: <br>
                <form:input path="price" type="number" />
                <form:errors path="price" cssClass="error" />
            </p>
            <p>
                <spring:message code="car.form.color"/>: <br>
                <form:input path="color" type="color" />
            </p>

            <input type="submit" />
        </form:form>
    </body>
</html>

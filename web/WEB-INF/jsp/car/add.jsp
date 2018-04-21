<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros</title>
        <style>
            .error { color: red; }
        </style>
    </head>
    <body>
        <h1>${car.id == null ? 'Adicione' : 'Edite'} um carro</h1>

        <form:form method="POST" modelAttribute="car">
            <form:hidden path="id" />
            <p>
                Nome: <br>
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
            </p>
            <p>
                Preço: <br>
                <form:input path="price" type="number" />
                <form:errors path="price" cssClass="error" />
            </p>

            <input type="submit" />
        </form:form>
    </body>
</html>

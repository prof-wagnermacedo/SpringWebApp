<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros</title>
    </head>
    <body>
        <h1>Adicione um carro</h1>

        <form:form method="POST">
            <p>
                Nome: <br>
                <input type="text" name="name" />
            </p>
            <p>
                Preço: <br>
                <input type="number" name="price" />
            </p>

            <input type="submit" />
        </form:form>
    </body>
</html>

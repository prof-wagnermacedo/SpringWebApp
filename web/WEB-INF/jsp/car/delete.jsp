<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmação para excluir</title>
    </head>
    <body>
        <h1>Confirmação para excluir</h1>
        <form method="post">
            <input type="hidden" value="${car.id}">
            <p>O carro "${car.name}" está para ser excluído.</p>
            <p><button>Confirmar exclusão</button></p>
        </form>
    </body>
</html>

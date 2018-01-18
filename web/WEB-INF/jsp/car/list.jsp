<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<h1>Cars</h1>

<c:forEach items="${carList}" var="car">
    <p>
            ${car.name}: $${car.price}
    </p>
    <ul>
        <c:forEach items="${car.accessories}" var="accessory">
            <li>${accessory.description}</li>
        </c:forEach>
    </ul>
</c:forEach>

</body>
</html>

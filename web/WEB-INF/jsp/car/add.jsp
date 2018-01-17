<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Add a car</h1>

<form:form method="POST" modelAttribute="car">
    <p>
        Name:
        <form:input path="name" />
        <form:errors path="name" cssClass="error" />
    </p>
    <p>
        Price:
        <form:input path="price" />
        <form:errors path="price" cssClass="error" />
    </p>

    <input type="submit" />
</form:form>

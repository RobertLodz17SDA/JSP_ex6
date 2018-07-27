<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.name != null}">
    <h3 style='color: green;'>Hello, you are logged as ${sessionScope.name}!</h3>
</c:if>
<h3>Login:</h3>
<ul>
    <c:if test="${sessionScope.name != null}">
        <li><a href="/logout">Logout</a></li>
    </c:if>
    <c:if test="${sessionScope.name == null}">
        <li><a href="/login">Login</a></li>
        <li><a href="/rejestcja">Login</a></li>
    </c:if>
</ul>

<h3>Menu:</h3>
<ul>
    <li><a href="/home">Home</a></li>
    <li><a href="/gallery">Gallery</a></li>
    <li><a href="/instagram">Instagram Gallery</a></li>
    <li><a href="/about">About</a></li>
    <li><a href="/contact">Contact</a></li>
</ul>

<h3>Database:</h3>
<ul>
    <li><a href="/addPerson">Add person</a></li>
    <li><a href="/showPersons">Show persons</a></li>
    <li><a href="/museums">Museums</a></li>
</ul>
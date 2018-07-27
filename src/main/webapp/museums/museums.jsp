<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Museums</title>
</head>
<body>
<h1>MUSEUMS</h1>
<jsp:include page="../menu.jsp"/>

<form method="POST" action="/museums">
    <table>
        <tr>
            <td>
                <select name="searchBy">
                    <option value="id">Lp</option>
                    <option value="name">Nazwa</option>
                    <option value="postalCode">Kod pocztowy</option>
                    <option value="city">Miasto</option>
                    <option value="streetPrefix">Ul./Al./Pl.</option>
                    <option value="street">Ulica</option>
                    <option value="houseNumber">Numer domu</option>
                    <option value="flatNumber">Numer lokalu</option>
                    <option value="organizer">Organizator</option>
                    <option value="entryDate">Data wpisu</option>
                    <option value="status">Status</option>
                </select>
            </td>
            <td><input type="text" name="searchValue"></td>
        </tr>
        <tr>
            <td>Szukaj:</td>
            <td><input type="submit" name="submit"></td>
        </tr>
    </table>
</form>

<table border="1">
    <tr>
        <th>Lp.</th>
        <th>Nazwa</th>
        <th>Kod pocztowy</th>
        <th>Miasto</th>
        <th>Ul./Al./Pl.</th>
        <th>Ulica</th>
        <th>Numer domu</th>
        <th>Numer lokalu</th>
        <th>Organizator</th>
        <th>Data wpisu</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${requestScope.museums}" var="museum">
        <tr>
            <td>${museum.getId()}</td>
            <td>${museum.getName()}</td>
            <td>${museum.getPostalCode()}</td>
            <td>${museum.getCity()}</td>
            <td>${museum.getStreetPrefix()}</td>
            <td>${museum.getStreet()}</td>
            <td>${museum.getHouseNumber()}</td>
            <td>${museum.getFlatNumber()}</td>
            <td>${museum.getOrganizer()}</td>
            <td>${museum.getEntryDate()}</td>
            <td>${museum.getStatus()}</td>
    </c:forEach>
</table>
</body>
</html>

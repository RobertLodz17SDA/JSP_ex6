<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Show persons</title>
</head>
<body>
<h1>SHOW PERSONS FROM DATABASE</h1>
<jsp:include page="../menu.jsp"/>

<table border="1">
    <tr>
        <td width="150"><b>Name:</b></td>
        <td width="150"><b>Surname:</b></td>
        <td width="150"><b>Year of birth:</b></td>
        <td width="150"><b>Phone number:</b></td>
        <td width="150"><b>Sex:</b></td>
    </tr>
    <c:forEach items="${requestScope.people}" var="person">
        <tr>
            <td>${person.getName()}</td>
            <td>${person.getSurname()}</td>
            <td>${person.getBornYear()}</td>
            <td>${person.getPhoneNumber()}</td>
            <td>${person.getSex()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
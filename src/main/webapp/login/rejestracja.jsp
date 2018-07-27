<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<h1>REJESTRACJA</h1>
<jsp:include page="../menu.jsp"/>


<c:if test="${requestScope.loginMessage != null}">
    <h3>${requestScope.loginMessage}</h3>
</c:if>
<c:if test="${cookie.user != null}">
    <h3>Hello, ${cookie.user.value}</h3>
</c:if>
<form method="POST" action="/rejestracja">
    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Zarejestruj" name="Zarejestruj"></td>
        </tr>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add person</title>
</head>
<body>
<h1>ADD PERSON TO DATABASE</h1>
<jsp:include page="../menu.jsp"/>

<form method="POST" action="/addPerson">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input type="text" name="surname"></td>
        </tr>
        <tr>
            <td>Year of birth:</td>
            <td><input type="text" name="year"></td>
        </tr>
        <tr>
            <td>Phone number:</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <%-- Pola input type="radio" umozliwiaja wybranie jednej z kilku opcji --%>
            <%-- "checked" oznacza domyslnie zaznaczona opcje --%>
            <%-- Przy odbiorze mozna odniesc sie do pola poprzez "name=" --%>
            <%-- i zostanie zwrocona wartosc "value=" z tego, ktory bedzie zaznaczony --%>
            <td>Sex:</td>
            <td>Male: <input type="radio" name="sex" value="MALE" checked></td>
            <td>Female: <input type="radio" name="sex" value="FEMALE"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add person" name="submit"></td>
        </tr>
    </table>
</form>

<a href="showPersons">Show all persons</a><br>

</body>
</html>
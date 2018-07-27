<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Instagram</title>
</head>
<body>
<h1>INSTAGRAM</h1>
<jsp:include page="menu.jsp"/>

<h4>Name: ${requestScope.instagramGallery.getName()}</h4>
<h4>Created: ${requestScope.instagramGallery.getCreated()}</h4>
<br>
<form method="POST" action="/instagram">
    <table>
        <tr><td>Type instagram user's name:</td></tr>
        <tr><td><input type="text" size="30" name="user" /></td></tr>
        <tr><td>Type max number of photos:</td></tr>
        <tr><td><input type="text" size="30" name="number" /></td></tr>
        <tr><td>Get user's photos!:</td></tr>
        <tr><td><input type="submit" value="Get photos" name="submit" /></td></tr>
    </table>
</form>
<c:if test="${requestScope.size() > 0}">
    <table border=1>
        <c:forEach items="${requestScope.instagramGallery.getImages()}" var="image">
            <tr>
                <td>
                    <img src="${image.getUrl()}" width="500px" title="${image.getDescription()}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
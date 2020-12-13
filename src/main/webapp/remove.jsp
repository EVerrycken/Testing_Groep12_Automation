<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Testing-Groep 12-Automation - Remove</title>
    <link rel="stylesheet" type="text/css" href="css/stylsheet.css">
</head>
<body>
<div id="container">
<header>
    <nav>
        <ul>
            <li><a href="Controller?command=Home">Overview</a></li>
            <li><a href="Controller?command=Add">Add</a></li>
            <li id="actual"><a href="Controller?command=Remove">Remove</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Remove</h2>
    <c:if test="${not empty errors}">
        <div class="alert-danger">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="POST" action="Controller?command=Remove" novalidate="novalidate">
        <p><label for="naam">Naam</label>
            <input type="text" id="naam" name="naam" required ></p>
        <p><input type="submit" id="remove" name="remove" value="remove"></p>
    </form>
</main>
<footer> Groep 12 - Automation &copy; Testing, UC Leuven-Limburg</footer>
</div>
</body>
</html>

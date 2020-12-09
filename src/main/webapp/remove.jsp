<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Remove</title>
</head>
<header>
    <h1>
        <span>Automation</span>
    </h1>
    <nav>
        <ul>
            <li><a href="Controller?">Overview</a></li>
            <li><a href="Controller?command=Add">Add</a></li>
            <li id="actual"><a href="Controller?command=Remove">Remove</a></li>
        </ul>
    </nav>
</header>
<body>
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
    <input type="hidden" name="remove" value="remove">
    <p><label for="naam">naam</label>
        <input type="text" id="naam" name="naam" required ></p>
    <p><input type="submit" id="remove" value="Remove"></p>
</form>

</body>
</html>

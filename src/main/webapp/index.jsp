<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Testing-Groep 12-Automation - Home</title>
    <link rel="stylesheet" type="text/css" href="css/stylsheet.css">
</head>
<body>
<div id="container">
<header>
    <nav>
        <ul>
            <li id="actual"><a href="Controller?command=Home">Overview</a></li>
            <li><a href="Controller?command=ToAddJsp">Add</a></li>
            <li><a href="Controller?command=ToRemoveJsp">Remove</a></li>
        </ul>
    </nav>
</header>
<main>
    <c:if test="${eten != null}">
        <table id="overview">
            <h2>Eten overview</h2>
            <tr>
                <th>Naam</th>
                <th>Prijs</th>
                <th>Categorie</th>
                <th>Extra info</th>
            </tr>
            <c:forEach var="eten" items="${eten}">
                <tr>
                    <td><c:out value='${eten.naam}'/></td>
                    <td><c:out value='${eten.prijs}'/></td>
                    <td><c:out value='${eten.categorie}'/></td>
                    <td><c:out value='${eten.extrainfo}'/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</main>
<footer> Groep 12 - Automation &copy; Testing, UC Leuven-Limburg</footer>
</div>
</body>
</html>

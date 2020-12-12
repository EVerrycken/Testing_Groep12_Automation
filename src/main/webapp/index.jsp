<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <c:choose>
        <c:when test="${!empty eten}">
            <table id="overview">
                <h2>Eten overview</h2>
                <tr>
                    <th>Naam</th>
                    <th>Prijs</th>
                    <th>Categorie</th>
                    <th>Allergieën</th>
                    <th>Vegetarisch</th>
                </tr>
                <c:forEach var="eten" items="${eten}">
                    <tr>
                        <td><c:out value='${eten.naam}'/></td>
                        <td><fmt:formatNumber type="number" minFractionDigits="2" value="${eten.prijs}"/> </td>
                        <td><c:out value='${eten.categorie}'/></td>
                        <td><c:out value='${eten.extrainfo}'/></td>
                        <td><c:choose>
                            <c:when test="${eten.vegetarisch == true}"><c:out value="Vegetarisch"></c:out></c:when>
                            <c:otherwise><c:out value="Niet vegetarisch"></c:out></c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p><a href="Controller?command=Sort" id="sort">Sort eten per categorie</a></p>
            <p><a href="Controller?command=RemoveAll" id="remove">Remove all eten</a></p>
        </c:when>
        <c:otherwise>
            <p class="alert">Er zijn momenteel geen beschikbare maaltijden op het menu</p>
        </c:otherwise>
    </c:choose>
</main>
<footer> Groep 12 - Automation &copy; Testing, UC Leuven-Limburg</footer>
</div>
</body>
</html>

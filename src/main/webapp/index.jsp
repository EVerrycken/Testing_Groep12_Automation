<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<title>Testing-Automation</title>
</head>
<body>
<header>
	<h1>
		<span>Automation</span>
	</h1>
	<nav>
		<ul>
			<li id="actual"><a href="Controller?">Overview</a></li>
			<li><a href="Controller?command=Add">Add</a></li>
			<li><a href="Controller?command=Remove">Remove</a></li>
		</ul>
	</nav>
</header>
<main>
	<c:if test="${eten != null}">
		<table id="overview">
			<caption>Eten Overview</caption>
			<tr>
				<th>Naam</th>
				<th>Prijs</th>
				<th>Extra info</th>
			</tr>
			<c:forEach var="eten" items="${eten}">
				<tr>
					<td><c:out value='${eten.naam}'/></td>
					<td><c:out value='${eten.prijs}'/></td>
					<td><c:out value='${eten.extraInfo}'/></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</main>
</body>
</html>

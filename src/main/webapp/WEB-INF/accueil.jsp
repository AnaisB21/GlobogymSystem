<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Accueil</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link href="./style.css" rel="stylesheet">
</head>

<body>
	<!-- utilisation des jspl pour inclure automatique un menu -->
	<jsp:include page="./menu.jsp"></jsp:include>
	
	<h1>Bienvenue</h1> 
	
	
	<c:if test="${not (requestScope['user1']ne null)}">
			Vous êtes connecté sous le nom ${sessionScope["user1"].nomUser}<br>
			Votre identifiant est ${sessionScope["user1"].mailUser} <br>
		</c:if>
	<br>
	<br>
	
 	
</body>
</html>
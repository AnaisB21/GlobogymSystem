<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
	<jsp:include page="./inc/_menu.jsp"></jsp:include>
	
	<c:if test="${sessionScope['sessionUser'] != null}">
	
	<div class="container">
		
		<h2 class="mt-5 display-7">Globogym Admin</h2>
		
		<h3 class="display-8">Les derniers cours ajoutés</h3>
		<div class="mt-3 row">
	    <c:forEach var="cours" items="${listeCours}">
	        <div class="col-md-4"> 
	            <div class="card" style="width: 18rem;">
	                <img class="card-img-top" src="./images/gymbackground.jpg" alt="Card image cap">
	                <div class="card-body">
	                    <h5 class="card-title">${cours.coursType.nom}</h5>
	                    <p class="card-text">Le ${cours.date} avec ${cours.coach.nom} ${cours.coach.prenom} </p>
	                    <a href="gestionreservations/cours?id=${cours.id}" class="btn btn-outline-dark">Voir les reservations</a>
	                </div>
	            </div>
	        </div>
	    </c:forEach>
	</div>

	</div>
	
	</c:if>
	
 	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des reservations</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="./inc/_menu.jsp"></jsp:include>

<div class="container mt-3">

	<h1>Liste des reservations du cours de ${cours.coursType.nom} du ${cours.date}</h1>
	
	<table class="table">
    	<thead class="bg-light">
	        <tr>
	            <th>Nom</th>
	            <th>Prénom</th>
	            <th>Action</th>
	        </tr>
        </thead>
        <tbody>
  			<c:forEach var="client" items="${listeClients}">
	            <tr>
	     
	                <td>
	                	<c:out value="${client.nom}"/>
	                </td>
	                <td>
	                	<c:out value="${client.prenom}"/>
	                </td>	                
	                <td>
	                	
	                	<a href="gestionclients/delete?id=${client.id}"> Retirer du cours </a>
	                </td>
	                
	            </tr>
        	</c:forEach>
        </tbody>        
    </table>
	
	    
	    <a href="gestionReservations/new" class="btn btn-success">Ajouter client</a>
</div>
</body>
</html>
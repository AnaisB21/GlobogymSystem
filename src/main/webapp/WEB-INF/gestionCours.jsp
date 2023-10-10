<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Gestion des Cours</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link href="./style.css" rel="stylesheet">
	
</head>

<body>
	<!-- utilisation des jspl pour inclure automatique un menu -->
	<jsp:include page="./_menu.jsp"></jsp:include>
	
	<h1>Liste des cours</h1>
	
	<a href="gestioncours/new" class="btn btn-success">Ajouter</a>
	
	<table class="table">
    	<thead class="bg-light">
	        <tr>
	        	<th>Id</th>
	            <th>Date</th>
	            <th>Coach </th>
	            <th>Cours</th>
	            <th>Action</th>
	        </tr>
        <thead>
        <tbody>
  			<c:forEach var="cours" items="${listeCours}">
	            <tr>
	             	<td>
	                	<c:out value="${cours.id}"/>
	                </td>
	                <td>
	                	<c:out value="${cours.date}"/>
	                </td>
	                <td>
	                	<c:out value="${cours.coach.prenom}"/>
	                </td>
	                <td>
	                	<c:out value="${cours.coursType.nom}"/>
	                </td>
	                <td>
                        <a href="gestioncours/delete?id=${cours.id}"> Supprimer </a>
	                </td>
	                
	            </tr>
        	</c:forEach>
        </tbody>        
    </table>
	
</body>
</html>
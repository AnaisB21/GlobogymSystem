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
	
	<table class="table">
    	<thead class="bg-light">
	        <tr>
	            <th>Date</th>
	            <th>Coach </th>
	            <th>Cours Type ID</th>
	        </tr>
        <thead>
        <tbody>
  			<c:forEach var="cours" items="${listeCours}">
	            <tr>
	                <td>
	                	<c:out value="${cours.date}"/>
	                </td>
	                <td>
	                	<c:out value="${cours.coach.nom} ${cours.coach.prenom}"/>
	                </td>
	                <td>
	                	<c:out value="${cours.coursType.nom}"/>
	                </td>
	     
	            </tr>
        	</c:forEach>
        </tbody>        
    </table>
	
</body>
</html>
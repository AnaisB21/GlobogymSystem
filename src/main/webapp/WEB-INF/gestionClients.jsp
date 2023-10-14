<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Gestion des Clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet">
</head>

<body>
    <!-- utilisation des jspl pour inclure automatique un menu -->
    <jsp:include page="./inc/_menu.jsp"></jsp:include>
<div class="container mt-3">
    <h1>Liste des clients</h1>

    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="client" items="${listeClients}">
                <tr>
                    <td>
                        <c:out value="${client.id}" />
                    </td>
                    <td>
                        <c:out value="${client.nom}" />
                    </td>
                    <td>
                        <c:out value="${client.prenom}" />
                    </td>
                    <td>
                        <a href="gestionclients/edit?id=${client.id}" class="btn btn-secondary">Modifier</a>
                        <a href="gestionclients/delete?id=${client.id}" class="btn btn-secondary">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="mt-3 text-center">
    	<a href="gestionclients/new" class="btn btn-outline-dark">Ajouter</a>
    </div>
 </div>
</body>

</html>

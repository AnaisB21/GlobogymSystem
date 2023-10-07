<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Gestion des Coachs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet">

</head>
<body>
    <!-- Utilisation des jspl pour inclure automatiquement un menu -->
    <jsp:include page="./_menu.jsp"></jsp:include>

    <h1>Liste des coachs</h1>

    <a href="gestioncoachs/new" class="btn btn-success">Ajouter</a>

    <table class="table">
        <thead class="bg-light">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="coach" items="${listeCoachs}">
                <tr>
                    <td>
                        <c:out value="${coach.id}"/>
                    </td>
                    <td>
                        <c:out value="${coach.nom}"/>
                    </td>
                    <td>
                        <c:out value="${coach.prenom}"/>
                    </td>
                    <td>
                        <a href="gestioncoachs/edit?id=${coach.id}"> Modifier </a>
                        <a href="gestioncoachs/delete?id=${coach.id}"> Supprimer </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
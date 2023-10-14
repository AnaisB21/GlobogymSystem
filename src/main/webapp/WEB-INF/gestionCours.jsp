<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Gestion des Cours</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet">
</head>

<body>
    <!-- utilisation des jspl pour inclure automatique un menu -->
    <jsp:include page="./inc/_menu.jsp"></jsp:include>

    <div class="container mt-3">
        <h2>Liste des cours</h2>

        <table class="mt-3 table table-striped table-bordered">
            <thead class="bg-light">
                <tr>
                    <th>Id</th>
                    <th>Date</th>
                    <th>Coach</th>
                    <th>Cours</th>
                    <th>Nb de Reservations</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cours" items="${listeCours}">
                    <tr>
                        <td>
                            <c:out value="${cours.id}" />
                        </td>
                        <td>
                            <c:out value="${cours.date}" />
                        </td>
                        <td>
                            <c:out value="${cours.coach.prenom}" />
                        </td>
                        <td>
                            <c:out value="${cours.coursType.nom}" />
                        </td>
                        <td class="text-center">
                            <span class="disabled btn btn-info"><c:out value="${cours.nbClients}"/>/20</span>
                        </td>
                        <td class="text-center">
                            <a href="gestioncours/delete?id=${cours.id}" class="btn btn-warning">Supprimer le cours</a>
                            <a href="gestionreservations/cours?id=${cours.id}" class="btn btn-secondary">Voir les réservations</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="mt-3 text-center">
         <a href="gestioncours/new" class="btn btn-outline-dark">Ajouter</a>
        </div>
    </div>
</body>
</html>

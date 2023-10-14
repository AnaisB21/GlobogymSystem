<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des reservations</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="./inc/_menu.jsp"></jsp:include>

<div class="container mt-3">

    <h2>Reservations du cours de ${cours.coursType.nom} du ${cours.date}</h1>

    <table class="mt-3 table table-striped table-bordered">
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
                        <c:out value="${client.nom}" />
                    </td>
                    <td>
                        <c:out value="${client.prenom}" />
                    </td>
                    <td class="text-center">
                        <a href="cours/delete?clientid=${client.id}&coursid=${cours.id}" class="btn btn-danger">Retirer du cours</a>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="text-center">
        <a href="cours/new?id=${cours.id}" class="btn btn-outline-dark">Ajouter client</a>
    </div>
    
</div>
</body>
</html>

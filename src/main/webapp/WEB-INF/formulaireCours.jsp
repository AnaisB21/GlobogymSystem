<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Formulaire Cours</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
    <jsp:include page="./_menu.jsp"></jsp:include>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <form action="${cours != null ? 'update' : 'insert'}" method="post">
                    <h2 class="mb-4">
                        ${cours != null ? 'Modifier cours' : 'Ajouter nouveau cours'}
                    </h2>

                    <input type="hidden" name="id" value="${cours != null ? cours.id : ''}" />

                    <div class="mb-3">
                        <label for="date" class="form-label">Date</label>
                        <input type="date" value="${cours != null ? cours.date : ''}" class="form-control" id="date" name="date" required="required">
                    </div>

                    <div class="mb-3">
                        <label for="coachId" class="form-label">Nom du coach</label>
                        <select class="form-select" name="coachId">
                            <c:forEach var="coach" items="${listeCoaches}">
                                <option value="${coach.id}"><c:out value="${coach.nom}" /></option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="coursTypeId" class="form-label">Type de Cours</label>
                        <select class="form-select" name="coursTypeId">
                            <c:forEach var="coursType" items="${listeCoursType}">
                                <option value="${coursType.id}"><c:out value="${coursType.nom}" /></option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-outline-dark">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
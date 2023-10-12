<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Formulaire coach</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
<jsp:include page="./_menu.jsp"></jsp:include>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <form action="${coach != null ? 'update' : 'insert'}" method="post">
                    <h2 class="mb-4">
                        ${coach != null ? 'Modifier coach' : 'Ajouter nouveau coach'}
                    </h2>

                    <input type="hidden" name="id" value="${coach != null ? coach.id : ''}" />

                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom coach</label>
                        <input type="text" value="${coach != null ? coach.nom : ''}" class="form-control" id="nom" name="nom" required="required">
                    </div>

                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prénom coach</label>
                        <input type="text" value="${coach != null ? coach.prenom : ''}" class="form-control" id="prenom" name="prenom">
                    </div>

                    <button type="submit" class="btn btn-dark">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>

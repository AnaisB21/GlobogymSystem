<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Formulaire client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
<jsp:include page="./inc/_menu.jsp"></jsp:include>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <form action="${client != null ? 'update' : 'insert'}" method="post">
                    <h2 class="mb-4">
                        ${client != null ? 'Modifier client' : 'Ajouter nouveau client'}
                    </h2>

                    <input type="hidden" name="id" value="${client != null ? client.id : ''}" />

                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom client</label>
                        <input type="text" value="${client != null ? client.nom : ''}" class="form-control" id="nom" name="nom" required="required">
                    </div>

                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prénom client</label>
                        <input type="text" value="${client != null ? client.prenom : ''}" class="form-control" id="prenom" name="prenom">
                    </div>

                    <button type="submit" class="btn btn-dark">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>
</body>

</html>

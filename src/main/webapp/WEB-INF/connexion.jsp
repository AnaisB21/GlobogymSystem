<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./inc/_menu.jsp"></jsp:include>
    <div class="container">
        
		<h2 class="mt-5 display-7">Globogym Admin</h2>

     
        <div class="card mt-5">
            <div class="card-header">
                <h5 class="card-title">Veuillez vous identifier</h5>
            </div>
            <div class="card-body">
                <form action="./accueil" method="POST">
                    <div class="form-group">
                        <label for="inpEmail">Email :</label>
                        <input type="text" class="form-control" id="inpEmail" name="email" placeholder="Inscrivez votre email" required>
                    </div>

                    <div class="form-group">
                        <label for="inpMotdepasse">Mot de passe :</label>
                        <input type="password" class="form-control" id="inpMotdepasse" name="motdepasse" placeholder="Inscrivez votre mot de passe" required>
                    </div>

                    <button type="submit" class="mt-3 btn btn-outline-dark">Se connecter</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>

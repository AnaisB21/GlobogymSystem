<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Connexion</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link href="./style.css" rel="stylesheet">
</head>

<body>
	<!-- utilisation des jspl pour inclure automatique un menu -->
	<jsp:include page="./menu.jsp"></jsp:include>

	<h1>Globogym System</h1>


	<fieldset>
			<legend id="titreLegende"> Veuillez vous identifier</legend>
            <form action="./Accueil" method="POST"> 
                <div>
                    <label for="inpEmail">Email : </label>
                    <input type="text" name="email" id="inpEmail" placeholder="Inscrivez votre email" required>
                </div>

                <div>
                    <label for="inpPassword">Mot de passe: </label>
                    <input type="password" name="password" id="inpPassword" placeholder="Inscrivez votre mot de passe" required>
                </div>

                <div>
                    <input type="submit" value="Se connecter" id="bouton">
                </div>
            </form>

	</fieldset>
	
	

</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Connexion</title>
	<link href="./style.css" rel="stylesheet">
</head>

<body>
	<!-- utilisation des jspl pour inclure automatique un menu -->
	<jsp:include page="./menu.jsp"></jsp:include>

	<h1>Globogym System</h1>

	<fieldset>
			<legend id="titreLegende"> Veuillez vous identifier</legend>
            <form action="./accueil" method="POST"> 
                <div>
                    <label for="inpEmail">Email : </label>
                    <input type="text" name="email" id="inpEmail" placeholder="Inscrivez votre email" required>
                </div>

                <div>
                    <label for="inpMotdepasse">Mot de passe: </label>
                    <input type="password" name="motdepasse" id="inpMotdepasse" placeholder="Inscrivez votre mot de passe" required>
                </div>

                <div>
                    <input type="submit" value="Se connecter" id="bouton">
                </div>
            </form>

	</fieldset>
	
	

</body>

</html>
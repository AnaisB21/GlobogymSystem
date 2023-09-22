<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	
		<nav class="navbar navbar-expand-sm navbar-light bg-light" >
			
				<img 
				class = "d-inligne-block align-top" 
				src ="https://img.freepik.com/vecteurs-premium/icone-calendrier-calendrier-logo-date-heure-icone_761928-109.jpg"
				width="50" height="50"/>
				
				<button
				type="button"
				data-bs-toggle="collapse"
				data-bs-target="#navbarNav"
				class="navbar-toggler"
				aria-controls="navbarNav"
				aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
				</button>
				
				<div
					class = "collapse navbar-collapse"
					id = "navbarNav">
					<ul class = "navbar-nav mr auto">
						<li class = "nav-item active">
							<a href="./connexion" class="nav-link">
								Connexion
							</a>
						</li>
						<li class = "nav-item active">
							<a href="./accueil" class="nav-link">
								Accueil								
							</a>
						</li>
						<li class = "nav-item active">
							<a href="./gestioncoachs" class="nav-link">
								Gestion des coachs
							</a>
						</li>
						<li class = "nav-item active">
							<a href="./gestionclients" class="nav-link">
								Gestion des clients
							</a>
						</li>
						<li class = "nav-item active">
							<a href="./gestioncours" class="nav-link">
								Gestion des cours
							</a>
						</li>
						<li class = "nav-item active">
							<a href="./planning" class="nav-link">
								Planning
							</a>
						</li>
					</ul>
				</div>			
		</nav>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
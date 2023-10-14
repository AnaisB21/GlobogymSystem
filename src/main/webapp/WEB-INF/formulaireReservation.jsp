<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Formulaire Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>

    <jsp:include page="./inc/_menu.jsp"></jsp:include>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <form action="insert" method="post">
                    <h2 class="mb-4">
                        Ajouter nouveau clients
                    </h2>
                    
                    <input type="hidden" name="coursId" value="${cours.id}" />
	
                    <div class="mb-3">
                        <label for="clientId" class="form-label">Clients</label>
                        <select class="form-select" name="clientId">
                            <c:forEach var="client" items="${listeClients}">
                                <option value="${client.id}"><c:out value="${client.nom} ${client.prenom }" /></option>
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
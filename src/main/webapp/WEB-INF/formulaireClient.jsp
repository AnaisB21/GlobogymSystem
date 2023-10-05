<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Formulaire client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
 	<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${client != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${client == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${client != null}">
                                    Modifier client
                                </c:if>
                                <c:if test="${client == null}">
                                    Ajouter nouveau client
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${client != null}">
                            <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                        </c:if>
                        <fieldset class="form-group">
                            <label>Nom client</label> <input type="text" value="<c:out value='${client.nom}' />" class="form-control" name="nom" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Prénom client</label> <input type="text" value="<c:out value='${client.prenom}' />" class="form-control" name="prenom">
                        </fieldset>
                     
                        <button type="submit" class="btn btn-success">Enregistrer</button>
                        </form>
                    </div>
                </div>
            </div>

</body>
</html>
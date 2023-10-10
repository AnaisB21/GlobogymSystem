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
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${cours != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${ccours == null}">
                    <form action="insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${cours != null}">
                            Modifier cours
                        </c:if>
                        <c:if test="${cours == null}">
                            Ajouter nouveau cours
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${cours != null}">
                    <input type="hidden" name="id" value="<c:out value='${cours.id}' />" />
                </c:if>
                
                <fieldset class="form-group">
                    <label>Date</label> 
                    <input type="date" value="<c:out value='${cours.date}' />" class="form-control" name="date" required="required">
                </fieldset>

                 <fieldset class="form-group">
                    <label>Nom du coach</label> 
                    <select name="coachId">
                    <c:forEach var="coach" items="${listeCoaches}">
                    	<option value="${coach.id}"><c:out value="${coach.nom}"></c:out></option>
                    </c:forEach>
                    </select>
                </fieldset>
                
                                <fieldset class="form-group">
                    <label>Type de Cours</label> 
                    <select name="coursTypeId">
                     <c:forEach var="coursType" items="${listeCoursType}">
                    	<option value="${coursType.id}"><c:out value="${coursType.nom}"></c:out></option>
                    </c:forEach>
                    </select>
                </fieldset>
                <button type="submit" class="btn btn-success">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
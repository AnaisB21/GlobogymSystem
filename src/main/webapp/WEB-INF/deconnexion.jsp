<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Déconnexion</title>
    <!-- Include Bootstrap CSS from CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet">
</head>

<body>
    <!-- Add a Bootstrap container for content -->
   
        <!-- Include Bootstrap navbar -->
        <jsp:include page="./inc/_menu.jsp"></jsp:include>
        
         <div class="container">

        <!-- Use Bootstrap classes to style the content -->
        <div class="mt-5">
            <h1 class="text-center">A bientôt</h1>
        </div>

        <div class="mt-3">
            <p class="text-center">Vous êtes déconnecté.</p>
        </div>
    </div>
</body>

</html>

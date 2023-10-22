<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <img class="d-inline-block align-top"
         src="<%=request.getContextPath()%>/images/globogymlogo.png"
         width="50" height="50"/>
         

    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
        <c:if test="${sessionScope['sessionUser'] == null}">
            <li class="nav-item active">
                <a href="<%=request.getContextPath()%>/connexion" class="nav-link"> 
                    Connexion
                </a>
            </li>
        </c:if>
        
         <c:if test="${sessionScope['sessionUser'] != null}">
        
        	<li class="nav-item active">
                <a href="<%=request.getContextPath()%>/deconnexion" class="nav-link"> 
                    Deconnexion
                </a>
            </li>

            <li class="nav-item active">
                <a href="<%=request.getContextPath()%>/accueil" class="nav-link">
                    Accueil
                </a>
            </li>
            <li class="nav-item active">
                <a href="<%=request.getContextPath()%>/gestioncoachs" class="nav-link">
                    Gestion des coachs
                </a>
            </li>
            <li class="nav-item active">
                <a href="<%=request.getContextPath()%>/gestionclients" class="nav-link">
                    Gestion des clients
                </a>
            </li>
            <li class="nav-item active">
                <a href="<%=request.getContextPath()%>/gestioncours" class="nav-link">
                    Gestion des cours
                </a>
            </li>
            
         </c:if>
            
        </ul>
    </div>
</nav>
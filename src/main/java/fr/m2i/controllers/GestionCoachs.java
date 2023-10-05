package fr.m2i.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.m2i.bdd.GestBDD;
import fr.m2i.models.Coach;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/gestioncoachs")
public class GestionCoachs extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final String VUE = "/WEB-INF/gestionCoachs.jsp";   
	   
	private GestBDD bdd;
	
    public GestionCoachs() {
        super();
        this.bdd=new GestBDD();
       
    }
    
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

	    if ("deleteCoach".equals(action)) {
	        try {
	            deleteCoach(request, response);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {
		

		bdd.connection();

		List<Coach> listeCoaches = bdd.getAllCoaches();
		
		request.setAttribute("listeCoaches", listeCoaches); //je stocke la liste en tant qu'attribut de la requete
		
		request.getRequestDispatcher(VUE).forward(request, response);
		
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("coucou POST");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		bdd.addCoach(nom,prenom);
			
		doGet(request, response);
	}
	
	
private void deleteCoach(HttpServletRequest request, HttpServletResponse response)	 throws SQLException, IOException{
		
		
		long id=Long.parseLong(request.getParameter("id"));
		bdd.deleteCoach(id);
		
		response.sendRedirect(request.getContextPath() + "/gestioncoachs");
	}

}

package fr.m2i.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.m2i.bdd.GestBDD;
import fr.m2i.models.Client;

@WebServlet("/gestionclients")
public class GestionClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/gestionClients.jsp";   
   
	private GestBDD bdd;
	
    public GestionClients() {
        super();
        this.bdd=new GestBDD();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		bdd.connection();
		

		String action = request.getServletPath();
		
		try {
			switch(action) {
			
			case "/new":
				showNewForm(request, response);
				break;
			case "/ajout":
				ajoutClient(request, response);				
				break;
			case "/supprimer":
				break;
			case "/modifier":
				break;
			default:
				afficherClient(request, response);
				break;		
			}
		} catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void showNewForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VUE).forward(request, response);
	}
	
	private void ajoutClient(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
		
		Long id=Long.parseLong(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		//
		//Client newClient = new Client(id, nom, prenom);
		bdd.addClient(nom, prenom);
		response.sendRedirect("listeClients");
	}
		
	private void afficherClient	(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException,ServletException {
		
		System.out.println("coucou");
	
		List<Client> listeClients = bdd.getAllClients();
		
		request.setAttribute("listeClients", listeClients); //je stocke la liste en tant qu'attribut de la requete
		
		request.getRequestDispatcher(VUE).forward(request, response);
		
		
	}	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		}

		

	
	
}

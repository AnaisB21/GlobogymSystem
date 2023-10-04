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
	
	
		List<Client> listeClients = bdd.getAllClients();
		
		request.setAttribute("listeClients", listeClients); //je stocke la liste en tant qu'attribut de la requete
		
		request.getRequestDispatcher(VUE).forward(request, response);
		
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("coucou");	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		bdd.addClient(nom,prenom);
			
		doGet(request, response);
	}
			
			
		

		

	
	
}

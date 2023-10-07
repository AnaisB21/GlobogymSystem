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

@WebServlet(urlPatterns= {"/gestionclients", "/gestionclients/new", "/gestionclients/insert", "/gestionclients/delete", "/gestionclients/edit", "/gestionclients/update"})
public class GestionClients extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/gestionClients.jsp";  
	private final String FORM = "/WEB-INF/formulaireClient.jsp";
	private GestBDD bdd;
	
	
    public GestionClients() {
        super();
        this.bdd=new GestBDD();      
    }

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        doGet(request, response);
    	    }
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		bdd.connection();  
		
		try {
            switch (action) {
                case "/gestionclients/new":
                    showNewForm(request, response);
                    break;
                case "/gestionclients/insert":
                    insertClient(request, response);
                    break;
                case "/gestionclients/delete":
                    deleteClient(request, response);
                    break;
                case "/gestionclients/edit":
                    showEditForm(request, response);
                    break;
                case "/gestionclients/update":
                    updateClient(request, response);
                    break;
                default:
                    listClient(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
		
	
	
	private void listClient(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {    	

		List<Client> listClient = bdd.getAllClients();		
		request.setAttribute("listeClients", listClient); //je stocke la liste en tant qu'attribut de la requete		
		request.getRequestDispatcher(VUE).forward(request, response);
	    }	
		
	
	private void showNewForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(FORM).forward(request, response);
	}	
		
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	
		Long id=Long.parseLong(request.getParameter("id"));	
		Client existingClient = bdd.selectClient(id);
		request.setAttribute("client", existingClient);
		request.getRequestDispatcher("/WEB-INF/formulaireClient.jsp").forward(request, response);
		
	}	
		
	private void insertClient(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");		
		bdd.addClient(nom, prenom);
		response.sendRedirect(request.getContextPath() + "/gestionclients");
	}	


	private void updateClient(HttpServletRequest request, HttpServletResponse response)	 throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		bdd.updateClient(id, nom, prenom);
		
		
		response.sendRedirect(request.getContextPath() + "/gestionclients");
	}		
		
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response)	 throws SQLException, IOException{		
		
		Long id=Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		bdd.deleteClient(id);		
		response.sendRedirect(request.getContextPath() + "/gestionclients");
	}
	
}

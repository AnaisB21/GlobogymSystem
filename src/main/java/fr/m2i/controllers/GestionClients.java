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

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        doGet(request, response);
    	    }
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		bdd.connection();  
		
		try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertClient(request, response);
                    break;
                case "/delete":
                    deleteClient(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
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
		System.out.println("méthode showNewForm, ok");
		//request.getRequestDispatcher("/WEB-INF/formulaireClient.jsp").forward(request, response);
	}	
		
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	
		Long id=Long.parseLong(request.getParameter("id"));
		System.out.println(id);		
		Client existingClient = bdd.selectClient(id);
		request.getRequestDispatcher("/WEB-INF/formulaireClient.jsp").forward(request, response);
		request.setAttribute("client", existingClient);
	}	
		
	private void insertClient(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException {	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");		
		bdd.addClient(nom, prenom);
	}	


	private void updateClient(HttpServletRequest request, HttpServletResponse response)	 throws SQLException, IOException{
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
	
		Client client = new Client(nom, prenom);
		bdd.updateClient(client);		
		response.sendRedirect(request.getContextPath() + "/gestionclients");
	}		
		
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response)	 throws SQLException, IOException{		
		
		Long id=Long.parseLong(request.getParameter("id"));
		bdd.deleteClient(id);		
		response.sendRedirect(request.getContextPath() + "/gestionclients");
	}
	
}

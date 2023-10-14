package fr.m2i.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.m2i.bdd.GestBDD;
import fr.m2i.models.Client;
import fr.m2i.models.Coach;
import fr.m2i.models.Cours;
import fr.m2i.models.CoursType;
import fr.m2i.models.Reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/gestionreservations/cours", "/gestionreservations/cours/new", "/gestionreservations/cours/insert", "/gestionreservations/cours/delete" })
public class GestionReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/gestionReservations.jsp"; 
	private final String FORM = "/WEB-INF/formulaireReservation.jsp";
	private GestBDD bdd;

  
    public GestionReservations() {
    	super();
        this.bdd = new GestBDD();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getServletPath();
	    bdd.connection();
	      
	      try {
	            switch (action) {
	            
	                case "/gestionreservations/cours/new":
	                    showNewForm(request, response);
	                    break;
	               
	                case "/gestionreservations/cours/insert":
	                    insertReservation(request, response);
	                    break;
	                   
	                case "/gestionreservations/cours/delete":
	                    deleteReservation(request, response);
	                    break;
	                    
	      
	                default:
	                    listReservations(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
		
	}
	
	 private void listReservations(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
		 
		
		Long coursId = Long.parseLong(request.getParameter("id"));
		Cours cours = bdd.selectCours(coursId);
		
		List <Client> listeClients = bdd.getAllClientsFromCours(cours);
				
		
		request.setAttribute("cours", cours);
		request.setAttribute("listeClients", listeClients);
		
	    request.getRequestDispatcher(VUE).forward(request, response);
	 }
	 
	 
	 private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Long coursId = Long.parseLong(request.getParameter("id"));
		 Cours cours = bdd.selectCours(coursId);
		 
		List <Client> listeClientsNonInscrits = bdd.getAllClientsNotInCours(cours);
	
		
		request.setAttribute("cours", cours);
		request.setAttribute("listeClients", listeClientsNonInscrits);
		 
		request.getRequestDispatcher(FORM).forward(request, response);
	   }
	 
	 
	 private void insertReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		  
		 String coursIdS = request.getParameter("coursId");
		 Long coursId = Long.parseLong(request.getParameter("coursId"));
		 Long clientId = Long.parseLong(request.getParameter("clientId"));
		 
		 Cours cours = bdd.selectCours(coursId);
		 Client client = bdd.selectClient(clientId);
		
		 bdd.addClientToReservation(client, cours);
		
	
		 response.sendRedirect(request.getContextPath() + "/gestionreservations/cours?id="+ coursIdS);
		 
	    }
	 
	 private void deleteReservation(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	        
		 String coursIdS = request.getParameter("coursid");
		 Long coursId = Long.parseLong(request.getParameter("coursid"));
		 Long clientId = Long.parseLong(request.getParameter("clientid"));
		 
		 Cours cours = bdd.selectCours(coursId);
		 Client client = bdd.selectClient(clientId);
		 
		 bdd.deleteClientFromReservation(client, cours);
		 
	     response.sendRedirect(request.getContextPath() + "/gestionreservations/cours?id=" + coursIdS);
	    }
	
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

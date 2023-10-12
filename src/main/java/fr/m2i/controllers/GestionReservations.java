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


@WebServlet("/gestionreservations/cours")
public class GestionReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/gestionReservations.jsp"; 
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
	            /*
	                case "/gestioncours/new":
	                    showNewForm(request, response);
	                    break;
	                case "/gestioncours/insert":
	                    insertCours(request, response);
	                    break;
	                case "/gestioncours/delete":
	                    deleteCours(request, response);
	                    break;
	                    
	               */
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
		
		
		List <Long> listClientId = bdd.getAllClientIdFromCours(cours);
		
		List <Client> listClients = new ArrayList <Client>();
		
		for (Long clientId : listClientId) {
			Client client = bdd.selectClient(clientId);
			listClients.add(client);
		}
		
		List <CoursType> listCoursType = bdd.getAllCoursType();
		
		for (CoursType coursType : listCoursType ) {
			if (coursType.getId() == cours.getCourstypeId()) {
				cours.setCoursType(coursType);
			}
		}
		
		
		 request.setAttribute("cours", cours);
		 request.setAttribute("listClients", listClients);
		
	     request.getRequestDispatcher(VUE).forward(request, response);
	 }
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

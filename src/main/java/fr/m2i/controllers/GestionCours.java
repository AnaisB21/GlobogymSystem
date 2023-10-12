package fr.m2i.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.m2i.bdd.GestBDD;
import fr.m2i.models.Client;
import fr.m2i.models.Coach;
import fr.m2i.models.Cours;
import fr.m2i.models.CoursType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/gestioncours", "/gestioncours/new", "/gestioncours/insert", "/gestioncours/delete", "/gestioncours/edit", "/gestioncours/update"} )
public class GestionCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/gestionCours.jsp"; 
	private final String FORM = "/WEB-INF/formulaireCours.jsp";

	private GestBDD bdd;

    public GestionCours() {
    	this.bdd=new GestBDD();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  String action = request.getServletPath();
	      bdd.connection();
	      
	      try {
	            switch (action) {
	                case "/gestioncours/new":
	                    showNewForm(request, response);
	                    break;
	                case "/gestioncours/insert":
	                    insertCours(request, response);
	                    break;
	                case "/gestioncours/delete":
	                    deleteCours(request, response);
	                    break;
	                default:
	                    listCours(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	      
	      
	}
		
	
	private void listCours(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		
		List<Cours> listeCours = bdd.getAllCours();
		
		List<Coach> listeCoaches = bdd.getAllCoaches();
		
		List <CoursType> listeCoursType = bdd.getAllCoursType();
		
		for (Cours cours : listeCours) {
			
			for (Coach coach : listeCoaches) {
				if (cours.getCoachId() == coach.getId()) {
					cours.setCoach(coach);
					break;
				}
			}
			for (CoursType coursType : listeCoursType) {
				if (cours.getCourstypeId() == coursType.getId()) {
					cours.setCoursType(coursType);
					break;
					}
			}
		
		}
	
		request.setAttribute("listeCours", listeCours);
		request.getRequestDispatcher(VUE).forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Coach> listeCoaches = bdd.getAllCoaches();
			List <CoursType> listeCoursType = bdd.getAllCoursType();
			
			request.setAttribute("listeCoaches", listeCoaches);
			request.setAttribute("listeCoursType", listeCoursType);
			
	        request.getRequestDispatcher(FORM).forward(request, response);
	   }
	
	  private void insertCours(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		  
		  String date = request.getParameter("date");
		  int coachId = Integer.parseInt(request.getParameter("coachId"));
		  int coursTypeId = Integer.parseInt(request.getParameter("coursTypeId"));
		  
		  bdd.addCours(date, coachId, coursTypeId);
		  
		  response.sendRedirect(request.getContextPath() + "/gestioncours");
		 

	    }
	  
	  private void deleteCours(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		  // TO DO
	        Long id = Long.parseLong(request.getParameter("id"));
	        bdd.deleteCours(id);
	        response.sendRedirect(request.getContextPath() + "/gestioncours");
	    }
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package fr.m2i.controllers;

import java.io.IOException;
import java.util.List;

import fr.m2i.bdd.GestBDD;
import fr.m2i.models.Coach;
import fr.m2i.models.Cours;
import fr.m2i.models.CoursType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gestioncours")
public class GestionCours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/gestionCours.jsp"; 

	private GestBDD bdd;

    public GestionCours() {
    	this.bdd=new GestBDD();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		bdd.connection();
		
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
		request.setAttribute("listeCoaches", listeCoaches);
		
		request.getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

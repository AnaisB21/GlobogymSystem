package fr.m2i.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


import fr.m2i.bdd.GestBDD;
import fr.m2i.models.Utilisateur;


@WebServlet("/accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE = "/WEB-INF/accueil.jsp";
       
 
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String motdepasse = request.getParameter("motdepasse");
		String email = request.getParameter("email");
		
		GestBDD bdd = new GestBDD();
		bdd.connection();
		if (bdd.userExist(email, motdepasse)) {
			Utilisateur sessionUser = bdd.findUser(email, motdepasse);
			request.getSession().setAttribute("sessionUser", sessionUser);
		}
		else {
			request.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		}
		bdd.close();

		doGet(request, response);
	}

}

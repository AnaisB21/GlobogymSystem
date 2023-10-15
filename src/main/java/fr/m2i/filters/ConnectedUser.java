package fr.m2i.filters;

import java.io.IOException;


import fr.m2i.models.Utilisateur;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;


@WebFilter({"/gestionclients", "/gestionclients/new", "/gestionclients/insert", "/gestionclients/delete", "/gestionclients/edit", "/gestionclients/update",
	"/gestioncoachs", "/gestioncoachs/new", "/gestioncoachs/insert", "/gestioncoachs/delete", "/gestioncoachs/edit", "/gestioncoachs/update",
	"/gestioncours", "/gestioncours/new", "/gestioncours/insert", "/gestioncours/delete", "/gestioncours/edit", "/gestioncours/update",
	"/gestionreservations/cours", "/gestionreservations/cours/new", "/gestionreservations/cours/insert", "/gestionreservations/cours/delete"})
public class ConnectedUser extends HttpFilter implements Filter {
       
 
    public ConnectedUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		
		Utilisateur sessionUser = (Utilisateur) ((HttpServletRequest)request).getSession().getAttribute("sessionUser");
		if (sessionUser != null) {
		chain.doFilter(request, response);
		}
		else {
		request.getServletContext().getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

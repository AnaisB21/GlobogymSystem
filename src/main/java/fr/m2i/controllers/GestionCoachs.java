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
import fr.m2i.models.Coach;

@WebServlet(urlPatterns = { "/gestioncoachs", "/gestioncoachs/new", "/gestioncoachs/insert", "/gestioncoachs/delete", "/gestioncoachs/edit", "/gestioncoachs/update" })
public class GestionCoachs extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String VUE = "/WEB-INF/gestionCoachs.jsp";
    private final String FORM = "/WEB-INF/formulaireCoach.jsp";
    private GestBDD bdd;

    public GestionCoachs() {
        super();
        this.bdd = new GestBDD();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        bdd.connection();

        try {
            switch (action) {
                case "/gestioncoachs/new":
                    showNewForm(request, response);
                    break;
                case "/gestioncoachs/insert":
                    insertCoach(request, response);
                    break;
                case "/gestioncoachs/delete":
                    deleteCoach(request, response);
                    break;
                case "/gestioncoachs/edit":
                    showEditForm(request, response);
                    break;
                case "/gestioncoachs/update":
                    updateCoach(request, response);
                    break;
                default:
                    listCoach(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCoach(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Coach> listCoach = bdd.getAllCoaches();
        request.setAttribute("listeCoachs", listCoach);
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(FORM).forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Coach existingCoach = bdd.selectCoach(id);
        request.setAttribute("coach", existingCoach);
        request.getRequestDispatcher("/WEB-INF/formulaireCoach.jsp").forward(request, response);
    }

    private void insertCoach(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        bdd.addCoach(nom, prenom);
        response.sendRedirect(request.getContextPath() + "/gestioncoachs");
    }

    private void updateCoach(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        bdd.updateCoach(id, nom, prenom);
        response.sendRedirect(request.getContextPath() + "/gestioncoachs");
    }

    private void deleteCoach(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        bdd.deleteCoach(id);
        response.sendRedirect(request.getContextPath() + "/gestioncoachs");
    }
}
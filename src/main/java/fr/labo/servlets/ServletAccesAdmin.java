package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.List;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bll.VenteManager;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Utilisateur;

/**
 * Servlet implementation class ServletAccesAdmin
 */
public class ServletAccesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccesAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HttpSession session = request.getSession(); Utilisateur admin = (Utilisateur)
		 session.getAttribute("user"); 
		 if (admin == null || admin.getAdministrateur()== false) {
			  response.sendRedirect("./ServletAccesIndexJsp");
			  return;
		  }
		 
		UtilisateurManager userManager = new UtilisateurManager();
		List<Utilisateur> userList = userManager.getAll();
		request.setAttribute("allUsers", userList);
		VenteManager venteManager = new VenteManager();
		List<Categorie> categories = venteManager.getAllCategories();
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("userId");
		if(idString != null) {
			int id = Integer.parseInt(idString);
			UtilisateurManager userManager = new UtilisateurManager();
			userManager.deleteUser(id);
		}
		Categorie cat = new Categorie(request.getParameter("categorie"));
		if(cat != null) {
			VenteManager venteManager = new VenteManager();
			venteManager.ajuterCategorie(cat);
		}
		response.sendRedirect("./ServletAccesAdmin");
	}

}

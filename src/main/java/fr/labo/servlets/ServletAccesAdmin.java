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
		
		/*
		 * HttpSession session = request.getSession(); Utilisateur admin = (Utilisateur)
		 * session.getAttribute("user"); if (admin == null ||
		 * admin.getAdministrateur()==false) {
		 * response.sendRedirect("./ServletAccesIndexJsp");
		 * 
		 * }else { System.out.println(admin); RequestDispatcher rd =
		 * request.getRequestDispatcher("./Admin.jsp"); rd.forward(request, response); }
		 */
		UtilisateurManager userManager = new UtilisateurManager();
		List<Utilisateur> userList = userManager.getAll();
		request.setAttribute("allUsers", userList);
		VenteManager venteManager = new VenteManager();
		List<ArticleVendu> articleList = venteManager.getAllArticles();
		request.setAttribute("articles", articleList);
		
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("userId"));
		doGet(request, response);
	}

}

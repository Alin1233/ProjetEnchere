package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.labo.bll.VenteManager;
import fr.labo.bo.ArticleVendu;

/**
 * Servlet implementation class ServletDetailArticle
 */
public class ServletDetailArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetailArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		VenteManager venteManager = new VenteManager();
		
		Integer idArticle = Integer.parseInt(request.getParameter("noArticle"));
		ArticleVendu articleVendu = venteManager.getArticleVendu(idArticle);
		
		request.setAttribute("article", articleVendu);
		RequestDispatcher rd = request.getRequestDispatcher("/detailArticle.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("error", "Tout les champs doivent être renseigné");
		request.getRequestDispatcher("detailArticle.jsp").forward(request, response);
	}

}

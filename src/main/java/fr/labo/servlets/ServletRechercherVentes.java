package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.labo.bll.VenteManager;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;

/**
 * Servlet implementation class ServletRechercherVentes
 */
public class ServletRechercherVentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercherVentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categorieString = request.getParameter("categorie");
		String searchString = request.getParameter("search");
		VenteManager venteManager = new VenteManager();
		List<ArticleVendu> articlesToSend = new ArrayList<ArticleVendu>();
		
		if (searchString == null || searchString.trim().isEmpty()) {
			venteManager = new VenteManager();
			if(categorieString.equals("all")) {
				articlesToSend =  venteManager.getAllArticles();
			}else {
				List<Categorie> allCategories = venteManager.getAllCategories();
				for(Categorie categorie: allCategories) {
					if(categorie.getLibelle().equals(categorieString)) {
						articlesToSend = venteManager.getAllArticlesDansCategorie(categorie);
					}
				}
			}
		}else {
			List<ArticleVendu> articleToFilter = venteManager.getAllArticles();
			for(ArticleVendu article: articleToFilter) {
				if(article.getNomArticle().toLowerCase().contains(searchString.toLowerCase())) {
					articlesToSend.add(article);
				}
			}
		}
		this.getServletContext().setAttribute("listeArticles", articlesToSend);
		 RequestDispatcher rd = request.getRequestDispatcher("ServletAccesIndexJsp");
	     rd.forward(request, response);
		//doGet(request, response);
	}

}

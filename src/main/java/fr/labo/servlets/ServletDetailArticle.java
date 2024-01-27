package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.labo.bll.VenteManager;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;

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
		
		List<Enchere> listEncheres = venteManager.getEncheresByArticle(idArticle);
		request.setAttribute("article", articleVendu);
		RequestDispatcher rd = request.getRequestDispatcher("/detailArticle.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		VenteManager venteManager = new VenteManager();
		if(request.getParameter("montant")!=null) {
			Integer montant = Integer.parseInt(request.getParameter("montant"));
			Integer idArticle = Integer.parseInt(request.getParameter("idArticle"));
			ArticleVendu articleVendu = venteManager.getArticleVendu(idArticle);
			HttpSession session = request.getSession(false);
			Utilisateur user = (Utilisateur)session.getAttribute("user"); 
			Enchere newEnchere = new Enchere(LocalDate.now().toString(),montant,user,articleVendu);
			venteManager.ajuterEnchere(newEnchere);
			articleVendu.setPrixVente(montant);
			venteManager.updateArticle(articleVendu);
			
		}
		System.out.println(request.getParameter("montant"));
		request.setAttribute("error", "Tout les champs doivent être renseigné");
		request.getRequestDispatcher("detailArticle.jsp").forward(request, response);
	}

}

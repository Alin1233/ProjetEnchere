package fr.labo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.labo.bll.VenteManager;
import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Utilisateur;

@WebServlet( "/ServletNouvelArticle" )
public class ServletNouvelArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "nouvelleVente.jsp" ).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VenteManager venteManager = new VenteManager();
		
		//Récuperation des information de l'utilisateur connecté
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		String vendeur = user.getPseudo();
		Adresse adresseUser = user.getAdresse();
		
		//Récupération des informations du formulaire
		//Paramètre de l'article
		String nomArticle = request.getParameter( "nomArticle");
		String description = request.getParameter("description" );
		String selectCategorie = request.getParameter( "selectCategorie" );
		Integer miseAPrix = Integer.parseInt(request.getParameter( "miseAPrix" )) ;
		String dateDebutEnchere = request.getParameter( "dateDebutEnchere" );
		String dateFinEnchere = request.getParameter( "dateFinEnchere" );
		String etatVente = "en cours";

		//Adresse de retrait
		String RetraitRue = request.getParameter( "RetraitRue" );
		String RetraitVille = request.getParameter( "RetraitVille" );
		String RetraitCodePostal = request.getParameter( "RetraitCodePostal" );
		
		//Création des objets
		ArticleVendu nouvelArticle = new ArticleVendu(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, 0, etatVente, selectCategorie, vendeur, adresseUser);
		Adresse adresse = new Adresse( RetraitRue , RetraitVille , RetraitCodePostal );
		//Insertion dans la bdd
		
		venteManager.ajuterVente(nouvelArticle);
		
		
		
		
		
		
		
		
		
		
		
	}

}
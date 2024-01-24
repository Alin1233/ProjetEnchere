package fr.labo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.labo.bll.VenteManager;
import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
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
		Categorie categorieArticle =null;
		
		
		//Récuperation des information de l'utilisateur connecté
		HttpSession session = request.getSession();
		Utilisateur vendeur = (Utilisateur) session.getAttribute("user");	
		
		try {
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
		
		//Recuperation de la Categorie (necessaire à la creation de l'article)
		List<Categorie> listeCategorie = venteManager.getAllCategories();
		for (Categorie categorie : listeCategorie) {
			
			if(selectCategorie.equals(categorie.getLibelle()) ){
				categorieArticle = categorie;
			}
		}

		
		//Création des objets
		Adresse adresseRetrait = new Adresse( RetraitRue , RetraitVille , RetraitCodePostal );
		ArticleVendu nouvelArticle = new ArticleVendu(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, 0, etatVente, categorieArticle, vendeur, adresseRetrait);
		//Insertion dans la bdd
		
		venteManager.ajuterVente(nouvelArticle);
		
		// Ajouter un attribut à la requête pour indiquer la réussite
		request.setAttribute("confirmationMessage", "L'article a été ajouté avec succès.");
		request.getRequestDispatcher("ServletAccesIndexJsp").forward(request, response);
		
		//Erreur, format différent attendue par la base de donnée
	   }catch (SQLException e) {
		
	        request.setAttribute("error", "Format non valide");
	        request.getRequestDispatcher("nouvelleVente.jsp").forward(request, response);
	        System.out.println("Erreur d'insertion de l'ArticleVendu " + e.getMessage());
		// Erreur formulaire vide
		}catch(Exception e){
			request.setAttribute("error", "Tout les champs doivent être renseigné");
			request.getRequestDispatcher("nouvelleVente.jsp").forward(request, response);
			System.out.println("Champs vide " + e.getMessage());
		}

		
		
	}

}

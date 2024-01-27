package fr.labo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
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
		
		//Permet d'identifer l'endroit d'où est appelé la servlet (depuis modif article "urlOrigin=modifier" ou "urlOrigin=nouvelArticle"
		String urlOrigin = request.getParameter("urlOrigin");
		//Recuperation de l'article si l'origine est depuis "urlOrigin=modifier" la modif de l'article
		HttpSession session = request.getSession();
		ArticleVendu articleAModifier = (ArticleVendu) session.getAttribute("articleVendu");
		//Création des objet pour la création/modif d'un article
		VenteManager venteManager = new VenteManager();
		Categorie categorieArticle =null;
		
		
		//Récuperation des information de l'utilisateur connecté
		
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
		
		//Si Servlet appelé depuis la JSP creationNouvlleVente 
		if(urlOrigin.equals("nouvelArticle")) {
			
			System.out.println("nouvelle article : "+nouvelArticle);
			
			venteManager.ajuterVente(nouvelArticle);
			// Ajouter un attribut à la requête pour indiquer la réussite
			request.setAttribute("confirmationMessage", "L'article a été ajouté avec succès.");
			request.getRequestDispatcher("nouvelleVente.jsp").forward(request, response);
		}
		//Si Servlet appelé depuis la JSP modificationArticle 
		else if(urlOrigin.equals("modifier"))
		{
			//Recuperation de l'id de l'article à modifier
			int idArticleAModifier = articleAModifier.getNoArticle();
			//Set de l'id sur le nouvelle article creé
			nouvelArticle.setNoArticle(idArticleAModifier);
			System.out.println("Article Modifier : " + nouvelArticle);
			venteManager.updateArticle(nouvelArticle);
			// Ajouter un attribut à la requête pour indiquer la réussite
			request.setAttribute("confirmationMessage", "L'article a été modifié avec succès.");
			request.getRequestDispatcher("modifierLaVente.jsp").forward(request, response);
		}
		
		
		//remplacer le nom de l'image téléchargée par le nom de l'article + le nom du seler
		String oldImage = (String) session.getAttribute("imagePath");
		File oldImageFile = new File(oldImage);
		String newImageName = nouvelArticle.getNomArticle()+"-"+ nouvelArticle.getVendeur().getPseudo()+".png";
		String newImagePath = oldImageFile.getParent() + File.separator + newImageName;
		File newImageFile = new File(newImagePath);
		oldImageFile.renameTo(newImageFile);
		
		
		// Ajouter un attribut à la requête pour indiquer la réussite
		request.setAttribute("confirmationMessage", "L'article a été ajouté avec succès.");
		request.getRequestDispatcher("nouvelleVente.jsp").forward(request, response);
		
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
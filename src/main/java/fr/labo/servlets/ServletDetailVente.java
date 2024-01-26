package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bll.VenteManager;
import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;

@WebServlet("/ServletDetailVente")
public class ServletDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetailVente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession se = request.getSession();
		Utilisateur utilisateurConnecte = (Utilisateur) se.getAttribute("user");
		
		
		VenteManager vm = new VenteManager();
		List<ArticleVendu> listeArticles = vm.getAllArticles();
		ArticleVendu Av = new ArticleVendu();
		
		
		for (ArticleVendu articleVendu : listeArticles) {
			if (articleVendu.getNomArticle().equals(request.getParameter("nomArticle")))
			{
				
				Av = articleVendu;
				
			}
		}
		
		//Création d'un attribut pour la récuperer l'article en vu d'une modification potentielle
		se.setAttribute("articleVendu", Av);
		
		
		UtilisateurManager um = new UtilisateurManager();
		String user = request.getParameter("pseudo");
		
		
		//Enchere En = new Enchere();
		String nom = Av.getNomArticle();
		String description = Av.getDescription();
		String categorie = Av.getCategorie().getLibelle();
		String vendeur = Av.getVendeur().getPseudo();
		String retrait = "Rue : " + Av.getRetrait().getRue() + " Ville : " + Av.getRetrait().getCodePostal();
		String dateDebutEncheres = Av.getDateDebutEncheres();
		String dateFinEncheres = Av.getDateFinEncheres();
		Integer miseAPrix = Av.getMiseAPrix();
		Integer prixVente = Av.getPrixVente();
		//Integer montant_enchere = En.getMontant_enchere();
		request.setAttribute("nom", nom);
		request.setAttribute("description", description);
		request.setAttribute("categorie", categorie);
		request.setAttribute("vendeur", vendeur);
		request.setAttribute("retrait", retrait);
		request.setAttribute("dateDebutEncheres", dateDebutEncheres);
		request.setAttribute("dateFinEncheres", dateFinEncheres);
		request.setAttribute("MiseAPrix", miseAPrix);
		request.setAttribute("PrixVente", prixVente);
		//request.setAttribute("Montant_Enchere", montant_enchere);
		RequestDispatcher rd = request.getRequestDispatcher("/detailVente.jsp");
		rd.forward(request, response);
		
	}


}
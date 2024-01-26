package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		System.out.println(utilisateurConnecte);
		request.setAttribute("utilisateurConnecte", utilisateurConnecte);
		String pseudoUc = utilisateurConnecte.getPseudo();


		
		
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
		String article = Av.getNomArticle();
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
		request.setAttribute("article", article);
		//request.setAttribute("Montant_Enchere", montant_enchere);
		
			LocalDate currentDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDate = currentDate.format(formatter);
			
			
			
			String dateDebutEnchere = Av.getDateDebutEncheres();
			
			
		    if (pseudoUc.equals(nom)) {
		    	if (dateDebutEnchere.compareTo(formattedDate) <=0) {
			        RequestDispatcher rd = request.getRequestDispatcher("/detailVenteVendeur.jsp");
			        rd.forward(request, response);
			        System.out.println("cas 1 je suis vendeur je peux modifier");
		    	} else {
			        RequestDispatcher rd = request.getRequestDispatcher("/detailVenteInfos.jsp");
			        rd.forward(request, response);
			        System.out.println("cas 2 je suis vendeur je ne peux pas modifier");
		    	}

		    } else if (dateDebutEnchere.compareTo(formattedDate) >=0 || dateFinEncheres.compareTo(formattedDate) <=0){
		        RequestDispatcher rd = request.getRequestDispatcher("/detailVenteInfos.jsp");
		        rd.forward(request, response);
		        System.out.println("cas 3 je suis vendeur et je ne peux pas encherir");
		    } else {
		        RequestDispatcher rd = request.getRequestDispatcher("/detailVenteAcheteur.jsp");
		        rd.forward(request, response);
		        System.out.println("cas 4 je suis acheteur et je peux encherir");
		    }
		} 


		

		}
		
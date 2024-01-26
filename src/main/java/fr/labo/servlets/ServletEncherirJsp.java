package fr.labo.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;
import fr.labo.dal.utilisateur.UtilisateurDAOJdbcImpl;
import fr.labo.dal.vente.VenteDAOJdbcImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServletEncherirJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEncherirJsp() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String enchereActuelle = request.getParameter("number");
		int SenchereActuelle = Integer.parseInt(enchereActuelle);
		
		
		//Recuperer l'acheteur
		HttpSession se = request.getSession();
		Utilisateur acheteur = (Utilisateur) se.getAttribute("user");
		request.setAttribute("acheteur", acheteur);
		
		//Recuperer encherisseur precedent
		String dernierEncherisseur;
		
		

		
		String nomArticle = request.getParameter("article");
		ArticleVendu article = new ArticleVendu(); 
		article.setNomArticle(nomArticle);
		
		String dateDebutEnchere = request.getParameter("dateDebutEnchere");
		Enchere enchere = new Enchere();
		enchere.setArticleVendu(article);
		enchere.setDateEnchere(dateDebutEnchere);
		
		
		int creditAcheteur = acheteur.getCredit();
		String ScreditAcheteur = String.valueOf(creditAcheteur);
		ArticleVendu Av = new ArticleVendu();
		int prixActuel = Av.getPrixVente();
		String SprixActuel = String.valueOf(prixActuel);
		
		
		 
		if (enchereActuelle.compareTo(ScreditAcheteur) <=0) {
			//Verif du credit suffisant pour encherir
	        if(enchereActuelle.compareTo(SprixActuel) >0) {
	        	//Mise à jour du credit de l'acheteur
	        	creditAcheteur = creditAcheteur - SenchereActuelle;
	        	acheteur.setCredit(creditAcheteur);
	        	UtilisateurDAOJdbcImpl utilisateurDAOJdbcImpl = new UtilisateurDAOJdbcImpl();
	        	utilisateurDAOJdbcImpl.update(acheteur);
	        	//Mise à jour du prix de vente
	        	prixActuel = prixActuel + SenchereActuelle;
	        	article.setPrixVente(prixActuel);
	        	VenteDAOJdbcImpl venteDAOJdbcImpl = new VenteDAOJdbcImpl();
	        	venteDAOJdbcImpl.updateArticle(article);
	        	//Mise à jour du credit de l'encherisseur precedent
	        	//creditAcheteurPrec = creditAcheteurPrec - SenchereActuelle;
	        	//acheteur.setCredit(creditAcheteur);
	        	//utilisateurDAOJdbcImpl.update(acheteur);
	        	//Determiner quel utilisateur à remporté l'enchère
	        	//Verifier que l'enchère est bien terminée : verifier que date enchere < date courante
	        	//verifier quel utilisateur à proposé l'enchère la plus haute
	        	
				LocalDate currentDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String formattedDate = currentDate.format(formatter);
				
				String dateFinEncheres = request.getParameter("dateFinEncheres");
	        	
				//Le dernier encherisseur devient acquereur
//	        	if (dateFinEncheres.compareTo(formattedDate) <=0) {
//	        		enchere.setUtilisateur(dernierEncherisseur);
//	        	}
	        	
	        }
	        	
	        
    	}else {
    		RequestDispatcher rd = request.getRequestDispatcher("/creditInsuffisant");
    		rd.forward(request, response);
    	}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/detailVenteAcheteur");
		
		
		
		
		
    	}
	
	

	}


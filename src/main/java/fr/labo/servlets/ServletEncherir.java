package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;

public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEncherir() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Utilisateur Us = new Utilisateur();
		ArticleVendu Av = new ArticleVendu();
		Enchere En = new Enchere();
		String nom = Us.getNom();
		String description = Av.getDescription();
		Categorie categorie = Av.getCategorie();
		Utilisateur vendeur = Av.getVendeur();
		Adresse retrait = Av.getRetrait();
		String dateFinEncheres = Av.getDateFinEncheres();
		Integer miseAPrix = Av.getMiseAPrix();
		Integer montant_enchere = En.getMontant_enchere();
		request.setAttribute("nom", nom);
		request.setAttribute("description", description);
		request.setAttribute("categorie", categorie);
		request.setAttribute("vendeur", vendeur);
		request.setAttribute("retrait", retrait);
		request.setAttribute("dateFinEncheres", dateFinEncheres);
		request.setAttribute("MiseAPrix", miseAPrix);
		request.setAttribute("Montant_Enchere", montant_enchere);
		RequestDispatcher rd = request.getRequestDispatcher("/encherir.jsp");
		rd.forward(request, response);
		
	}


}

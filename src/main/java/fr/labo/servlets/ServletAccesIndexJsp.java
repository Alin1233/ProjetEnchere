// Source code is decompiled from a .class file using FernFlower decompiler.
package fr.labo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bll.VenteManager;
import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletAccesIndexJsp")
public class ServletAccesIndexJsp extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public ServletAccesIndexJsp() {
   }

   public void init() throws ServletException {
	   
	   //Initialisation de la page index avec tout les articles présents dans la bdd
	   VenteManager venteManager = new VenteManager();
	   List<String> categorieListe = venteManager.getCategorieByLibelles();
	   List<ArticleVendu> ArticlesListe = venteManager.getAllArticles();
	   
	
      this.getServletContext().setAttribute("listeArticles", ArticlesListe);
      this.getServletContext().setAttribute("categorieListe", categorieListe);
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
      rd.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}

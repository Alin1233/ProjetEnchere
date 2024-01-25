// Source code is decompiled from a .class file using FernFlower decompiler.
package fr.labo.servlets;

import java.io.IOException;
import java.util.List;

import fr.labo.bll.VenteManager;
import fr.labo.bo.ArticleVendu;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	   
	  init();
   
      RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
      rd.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}

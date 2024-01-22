// Source code is decompiled from a .class file using FernFlower decompiler.
package fr.labo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Utilisateur;
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
      Categorie cat1 = new Categorie(1, "libelle-1");
      Categorie cat2 = new Categorie(2, "libelle-2 libelle-2 libelle-2");
      Categorie cat3 = new Categorie(3, "libelle-3");
      List<Categorie> categorieListe = new ArrayList();
      categorieListe.add(cat1);
      categorieListe.add(cat2);
      categorieListe.add(cat3);
      Adresse adresse = new Adresse("rueAdresse", "villeAdresse", "CPAdresse");
      Utilisateur user1 = new Utilisateur("Bagou1", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
      Utilisateur user2 = new Utilisateur("Bagou2", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
      Utilisateur user3 = new Utilisateur("Bagou3", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
      ArticleVendu art1 = new ArticleVendu("nomArticle1", "descriptionArticle1", "10/10/2020Art1", "10/12/2020Art1", 11, 111, "etatVenteArt1", cat1, user1, adresse);
      ArticleVendu art2 = new ArticleVendu("nomArticle2", "descriptionArticle2", "10/10/2020Art2", "10/12/2020Art2", 22, 222, "etatVenteArt2", cat2, user2, adresse);
      ArticleVendu art3 = new ArticleVendu("nomArticle3", "descriptionArticle3", "10/10/2020Art3", "10/12/2020Art3", 33, 333, "etatVenteArt3", cat3, user3, adresse);
      List<ArticleVendu> listeArticles = new ArrayList();
      listeArticles.add(art1);
      listeArticles.add(art2);
      listeArticles.add(art3);
      this.getServletContext().setAttribute("listeArticles", listeArticles);
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

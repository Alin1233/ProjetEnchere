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

    @Override
    public void init() throws ServletException {
		//////////////////////////////////////////////////////
		/////////////////////  Début     /////////////////////
		//////////////////////////////////////////////////////

        // Création liste catégorie pour test
        // En attente de la methode getAllCatégorie
        Categorie cat1 = new Categorie(1, "libelle-1");
        Categorie cat2 = new Categorie(2, "libelle-2 libelle-2 libelle-2");
        Categorie cat3 = new Categorie(3, "libelle-3");

        List<Categorie> categorieListe = new ArrayList<>();
        categorieListe.add(cat1);
        categorieListe.add(cat2);
        categorieListe.add(cat3);
		//////////////////////////////////////////////////////
		/////////////////      fin       /////////////////////
		//////////////////////////////////////////////////////
        
        

        
		//////////////////////////////////////////////////////
		/////////////////////  Début     /////////////////////
		//////////////////////////////////////////////////////
        
        // Création utilisateur et adresse vendeur pour test
        Adresse adresse = new Adresse("rueAdresse", "villeAdresse", "CPAdresse");
        Utilisateur user1 = new Utilisateur("Bagou1", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse,
                5000, true, "Pa$$w0rd");
        Utilisateur user2 = new Utilisateur("Bagou2", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse,
                5000, true, "Pa$$w0rd");
        Utilisateur user3 = new Utilisateur("Bagou3", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse,
                5000, true, "Pa$$w0rd");
		//////////////////////////////////////////////////////
		/////////////////      fin       /////////////////////
		//////////////////////////////////////////////////////
        
        

		//////////////////////////////////////////////////////
		/////////////////////  Début     /////////////////////
		//////////////////////////////////////////////////////
        // Création liste artile pour test
        // En attente de la méthode getAllArticles

        ArticleVendu art1 = new ArticleVendu("nomArticle1", "descriptionArticle1", "10/10/2020Art1",
                "10/12/2020Art1", (float) 11, (float) 111, "etatVenteArt1", cat1, user1, adresse);
        ArticleVendu art2 = new ArticleVendu("nomArticle2", "descriptionArticle2", "10/10/2020Art2",
                "10/12/2020Art2", (float) 22, (float) 222, "etatVenteArt2", cat2, user2, adresse);
        ArticleVendu art3 = new ArticleVendu("nomArticle3", "descriptionArticle3", "10/10/2020Art3",
                "10/12/2020Art3", (float) 33, (float) 333, "etatVenteArt3", cat3, user3, adresse);

        List<ArticleVendu> listeArticles = new ArrayList<>();
        listeArticles.add(art1);
        listeArticles.add(art2);
        listeArticles.add(art3);
		//////////////////////////////////////////////////////
		/////////////////      fin       /////////////////////
		//////////////////////////////////////////////////////

        // Stockez les données dans le contexte de l'application pour les rendre accessibles
        // à d'autres servlets ou filtres si nécessaire
        getServletContext().setAttribute("listeArticles", listeArticles);
        getServletContext().setAttribute("categorieListe", categorieListe);

    }
	/**
	 * Servlet d'accés à la JSP Index. Point d'entrée de l'application
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package fr.labo.servlets;

import fr.labo.bo.Adresse;
import fr.labo.bo.Utilisateur;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletCreationCompte() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		//Recuperer les infos pseudo et email afin de verifier leur unicité; 
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		int credit = 0;
		boolean administrateur = false;
		String motDePasse = request.getParameter("motDePasse");
		
		//Verification que tous les champs sont required, sinon renvoi vers la page creation compte (VERIF DANS LE JSP AVEC BALISE HTML REQUIRED)
		
		//Verifier unicité, si absent = poursuite de la creation de compte, si present, alors erreur et retour page accueil
		//Creation object Utilisateur
		//pseudo, nom, prenom, email, telephone, adresse, credit, administrateur, motDePasse
		Utilisateur utilisateur = new Utilisateur();
		//Verif unicité de deux variables
		// appel methode verif unicité de la BO User
		boolean pseudoUnique = utilisateur.pseudoUnique(pseudo);
		boolean emailUnique = utilisateur.emailUnique(email);

		// Logique verification
		if (pseudoUnique == true && emailUnique ==  true) {
		    // Continuer creation compte (Insert within DB)
			UtilisateurDAO utilisateurDAO = new UtilisateurDAO;
			UtilisateurDAO.insert(utilisateur);
		} else {
		    //Message erreur et retour page creation compte
			
		}


		
		}
		
	}

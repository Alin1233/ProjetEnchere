package fr.labo.servlets;

import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.utilisateur.UtilisateurDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletCreationCompte")//Mettre le lien de la JSP
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
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMp = request.getParameter("confirmationMp");
		
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
			if (motDePasse == confirmationMp) {
				// Continuer creation compte (Insert within DB)
				UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
				utilisateurDAO.insert(utilisateur);	
			}else {
			response.getWriter().println("Le mot de passe et le mot de passe de confirmation ne correspondent pas.");
			}
		} else {
		    //Message erreur et retour page creation compte
			response.getWriter().println("Le pseudo ou le mail est déjà utilisé.");	
		}

		}
		
	}

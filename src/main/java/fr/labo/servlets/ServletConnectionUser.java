package fr.labo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bo.Adresse;
import fr.labo.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletConnectionUser")
public class ServletConnectionUser extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/connectionUser.jsp");
		rd.forward(request, response);

    }

	/**
	 * Servlet de connextion des utilisateur
	 * Création d'un d'une session d'un utilisateur
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =  request.getSession(false);

		//------------------Créaetion d'un liste d'utilisateur pour test----------------------//
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		Adresse adresse = new Adresse("rueAdresse", "villeAdresse", "CPAdresse");
		Utilisateur user = new Utilisateur("Bagou", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
		Utilisateur user1 = new Utilisateur("Bagou1", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
		Utilisateur user2 = new Utilisateur("Bagou2", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
		
		utilisateurManager.ajouterUser(user);
		utilisateurManager.ajouterUser(user1);
		utilisateurManager.ajouterUser(user2);


		//------------------------------------------------------------------------------------//
		
		
		// Récupération des identifiants et mot de passe de l'utilisateur
		String pseudoUser = request.getParameter("pseudoUser");
		String passwordUser = request.getParameter("passwordUser");
		Utilisateur utilisateurExistant = utilisateurManager.verifierPseudoEtPassword(pseudoUser, passwordUser );
		
		if(utilisateurExistant != null) {
				session =  request.getSession(true);
				session.setAttribute("user", utilisateurExistant);
				response.sendRedirect("ServletAccesIndexJsp");

		}else {

			request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
			doGet(request, response);

		}

	}
}



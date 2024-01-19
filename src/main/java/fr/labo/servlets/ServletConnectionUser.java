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
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		// Récupération des identifiants et mot de passe de l'utilisateur
		String pseudoUser = request.getParameter("pseudoUser");
		String passwordUser = request.getParameter("passwordUser");
		//Vérification de l'existence dans la bdd
		Utilisateur utilisateurExistant = utilisateurManager.verifierPseudoEtPassword(pseudoUser, passwordUser );
		
		//Si existe, ouverture d'une session utilisateur et redirection vers index.jsp
		if(utilisateurExistant != null) {
				session =  request.getSession(true);
				session.setAttribute("user", utilisateurExistant);
				response.sendRedirect("ServletAccesIndexJsp");

		//Si n'existe pas, envoie message erreur et recharge la page 
		}else {

			request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
			doGet(request, response);

		}

	}
}



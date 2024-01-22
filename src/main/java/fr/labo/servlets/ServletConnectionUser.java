package fr.labo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bo.User;
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

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connectionUser.jsp");
		rd.forward(request, response);

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateurExistant = null;
		HttpSession session =  request.getSession(false);

		//------------------Créaetion d'un liste d'utilisateur pour test----------------------//
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		Adresse adresse = new Adresse("rueAdresse", "villeAdresse", "CPAdresse");
		Utilisateur user = new Utilisateur("Bagou", "coronas", "Louis-Philippe", "emailLouis-p", "0102030405", adresse, 5000, true, "Pa$$w0rd");
		
		utilisateurManager.ajouterUser(user);


		//------------------------------------------------------------------------------------//
		
		
		// Récupération des identifiants et mot de passe de l'utilisateur
		String pseudoUser = request.getParameter("pseudoUser");
		String passwordUser = request.getParameter("passwordUser");
		
		//////////////////////////////////////////////////////////////////////////////////////////
		//Remplacer méthode getUserById par getUserByPseudo(ou nom)
		if(utilisateurManager.verifierPseudoEtPassword(pseudoUser, passwordUser)) {
			utilisateurExistant = utilisateurManager.getUser(1);
			
		};
		//////////////////////////////////////////////////////////////////////////////////////////	
		
		if(utilisateurExistant != null) {
				session =  request.getSession(true);
				session.setAttribute("user", utilisateurExistant);
				response.sendRedirect("ServletAccesIndexJsp");

		}else {

			request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
			doGet(request, response);

		}



		//Si useur n'existe pas


		//----------------------------------------------------------//




	}
}



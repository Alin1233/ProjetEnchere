package fr.labo.servlets;

import java.io.IOException;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bo.Adresse;
import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.utilisateur.UtilisateurDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ServletCreationCompte")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      RequestDispatcher rd = request.getRequestDispatcher("/creationCompte.jsp");
	      rd.forward(request, response);
   }
    
    

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/creationCompte.jsp");
	      rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//Initialisation de l'utiliateur manager
		UtilisateurManager utilisateurManager = new UtilisateurManager();


		//Recuperer les infos de l'utilisateur
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		Adresse adresse = new Adresse(request.getParameter("rue"), request.getParameter("ville"), request.getParameter("codePostal"));
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMp = request.getParameter("confirmationMP");

		Utilisateur utilisateur = new Utilisateur();
		
				UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
				utilisateurDAO.insert(utilisateur);

		// Redirection apres saisir du formulaire vers page "connecté"
		response.sendRedirect("/connectionUser.jsp");

		}
		
	}
}

	

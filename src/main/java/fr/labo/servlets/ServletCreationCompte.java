package fr.labo.servlets;

import java.io.IOException;

import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.utilisateur.UtilisateurDAO;
import jakarta.servlet.RequestDispatcher;
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/creationCompte.jsp");
	      rd.forward(req, resp);
		
	}

	@Override
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

		Utilisateur utilisateur = new Utilisateur();
		
				UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
				utilisateurDAO.insert(utilisateur);

		// Redirection apres saisir du formulaire vers page "connecté"
		response.sendRedirect("/connectionUser.jsp");

		}

	}

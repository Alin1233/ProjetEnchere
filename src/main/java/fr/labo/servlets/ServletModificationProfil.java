package fr.labo.servlets;

import java.io.IOException;

import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.utilisateur.UtilisateurDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletModificationProfil() {
        super();
    }
    
    
    


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		
		Utilisateur Us = new Utilisateur();
		int	credit = Us.getCredit();
		req.setAttribute("credit", credit);
		RequestDispatcher rd = req.getRequestDispatcher("/modificationProfil.jsp");
		rd.forward(req, resp);
		
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		//Recuperer les champs modifiés (le "getParameter accepte un retour "null")
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMp = request.getParameter("confirmationMp");
		String newMp = request.getParameter("NewMp");
		
		//Update Utilisateur dans la DB
		Utilisateur user = new Utilisateur();
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.update(user);
		
		// Redirection apres saisir du formulaire vers page "AffichageProfil"
		response.sendRedirect("/affichageProfil.jsp");
		
	}

}

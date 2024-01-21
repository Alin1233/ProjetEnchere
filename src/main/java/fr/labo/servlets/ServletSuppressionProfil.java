package fr.labo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.utilisateur.UtilisateurDAO;

public class ServletSuppressionProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSuppressionProfil() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		Utilisateur utilisateur = new Utilisateur();
		
		
		//Récuperer l'ID de l'Utilisateur à supprimmer
		String idUser = request.getParameter("idUser");
		int idConvertie = Integer.parseInt(idUser);
		
		//Delete l'Utilisateur une fois qu'on a recuperé son ID
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		utilisateurDAO.delete(idConvertie);
		
		//Redirect vers la page de connexion "non-connecté"
		response.sendRedirect("/connexionUser.jsp");
	}

}

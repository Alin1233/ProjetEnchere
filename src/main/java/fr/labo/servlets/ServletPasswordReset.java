package fr.labo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bo.Utilisateur;

/**
 * Servlet implementation class ServletPasswordReset
 */
public class ServletPasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPasswordReset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/resetPassword.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur user = new Utilisateur();
	    String pseudoUser = request.getParameter("pseudoUser");
	    String passwordUser = request.getParameter("passwordUser");
	    user = utilisateurManager.getUserByPseudo(pseudoUser);
	    if(user !=null && passwordUser != null && !passwordUser.trim().isEmpty()) {
		    user.setMotDePasse(passwordUser);
		    utilisateurManager.updateUser(user);
	    }else {
	    	request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
	        this.doGet(request, response);
	    }
	    response.sendRedirect("ServletConnectionUser");
	}

}

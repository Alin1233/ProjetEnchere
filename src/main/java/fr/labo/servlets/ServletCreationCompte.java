package fr.labo.servlets;

import java.io.IOException;

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


@WebServlet("/ServletCreationCompte")//Mettre le lien de la JSP
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      RequestDispatcher rd = request.getRequestDispatcher("/creationCompte.jsp");
	      rd.forward(request, response);
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

		String ckeckExistingUser = utilisateurManager.checkPseudoEtEmail(pseudo,email);
		
		
		//vérifictaion de la double saisie du mot de passe
		
		if(!motDePasse.equals(confirmationMp)) {
	         request.setAttribute("erreurMdp", "Les mots de passe saisies ne correspondent pas");
	         this.doGet(request, response);
			
	         
	    //Verification si l'email ou le pseudo est déjà enregistré dans la base de donnée
		}else if (ckeckExistingUser.equals("email-pris") || ckeckExistingUser.equals("pseudo-pris")) {
			request.setAttribute("erreurUser", "L'email ou l'utilisateur est déjà enregistré");
			this.doGet(request, response);
			
		
		//Si l'utilisateur n'est pas encore enregistré dans base de donnée ("bon")	et que la saisie du mdp est valide	
		}else if(ckeckExistingUser.equals("bon")){
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, adresse, 0, false, motDePasse);
			utilisateurManager.ajouterUser(utilisateur);
			request.setAttribute("user", utilisateur);
			request.getRequestDispatcher("ServletConnectionUser").forward(request, response);	
		}
		
	}
}

	

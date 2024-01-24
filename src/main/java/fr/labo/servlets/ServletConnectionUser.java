// Source code is decompiled from a .class file using FernFlower decompiler.
package fr.labo.servlets;

import fr.labo.bll.UtilisateurManager;
import fr.labo.bo.Utilisateur;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/ServletConnectionUser"})
public class ServletConnectionUser extends HttpServlet {

   private static final long serialVersionUID = 1L;

   public ServletConnectionUser() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   // Récuperation de l'utilisateur lors de l'inscription pour se connecter à la suite de la validation du formulaire d'inscription
	   Utilisateur newUser = null;
	   newUser = (Utilisateur) request.getAttribute("user");
	   
	   // Si l'inscription est valide, connection de l'utilisateur et redirection vers la page d'accueil
	   if(newUser != null) {
		   doPost(request,response);
		   	
	   //Si l'inscription ou la connexion n'est pas valide, redirection vers la page de conection
	   }else {
		   
		   RequestDispatcher rd = request.getRequestDispatcher("/connectionUser.jsp");
		   rd.forward(request, response);
	   }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(false);
      Utilisateur utilisateurExistant = null;
      
      //Executer depuis la page de connexion, quand l'utilisateur existant souhaite se connecter
      if(request.getAttribute("user") == null){
    	  
	      UtilisateurManager utilisateurManager = new UtilisateurManager();
	      String pseudoUser = request.getParameter("pseudoUser");
	      String passwordUser = request.getParameter("passwordUser");
	      
	      utilisateurExistant = utilisateurManager.verifierPseudoEtPassword(pseudoUser, passwordUser);
	      
	      if (utilisateurExistant != null) {
	         session = request.getSession(true);
	         session.setAttribute("user", utilisateurExistant);
	         
	         //code qui concerne Sessions utilisateur de 5mn
	    	  long actionTime = System.currentTimeMillis();
	    	  session.setAttribute("actionPerformed", actionTime);
	         
	         response.sendRedirect("ServletAccesIndexJsp");
	      } else {
	         request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
	         this.doGet(request, response);
	      }
	      
      //Executé depuis la page d'inscription lorsque l'utilisateur valide son inscription
      }else {
    	  
    	  utilisateurExistant = (Utilisateur) request.getAttribute("user");
    	  session = request.getSession(true);
    	  session.setAttribute("user", utilisateurExistant);
    	  
    	  //code qui concerne Sessions utilisateur de 5mn
    	  long actionTime = System.currentTimeMillis();
    	  session.setAttribute("actionPerformed", actionTime);
    	  
    	  response.sendRedirect("ServletAccesIndexJsp");
      }

   }
}

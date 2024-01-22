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
      RequestDispatcher rd = request.getRequestDispatcher("/connectionUser.jsp");
      rd.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(false);
      UtilisateurManager utilisateurManager = new UtilisateurManager();
      String pseudoUser = request.getParameter("pseudoUser");
      String passwordUser = request.getParameter("passwordUser");
      Utilisateur utilisateurExistant = utilisateurManager.verifierPseudoEtPassword(pseudoUser, passwordUser);
      if (utilisateurExistant != null) {
         session = request.getSession(true);
         session.setAttribute("user", utilisateurExistant);
         response.sendRedirect("ServletAccesIndexJsp");
      } else {
         request.setAttribute("erreur", "l'utilisateur ou mot de passe n'est pas valide");
         this.doGet(request, response);
      }

   }

}

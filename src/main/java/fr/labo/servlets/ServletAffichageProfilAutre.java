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


		@WebServlet("/ServletAffichageProfilAutre")
		public class ServletAffichageProfilAutre extends HttpServlet {
			private static final long serialVersionUID = 1L;
		       
		    public ServletAffichageProfilAutre() {
		        super();
		    }

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("Served at: ").append(request.getContextPath());
				
				
				//Recuperer pseudo vendeur en parametre pour l'appel methode getUSerbyPSeudo
				
				
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				String ps = request.getParameter("pseudo");
				Utilisateur Us = new Utilisateur();
				Us = utilisateurManager.getUserByPseudo(ps);
				
				
				String pseudo = Us.getPseudo();
				String nom = Us.getNom();
				String prenom = Us.getPrenom();
				String email = Us.getEmail();
				String telephone = Us.getTelephone();
				Adresse adresse = Us.getAdresse();
				request.setAttribute("pseudo", pseudo);
				request.setAttribute("nom", nom);
				request.setAttribute("prenom", prenom);
				request.setAttribute("email", email);
				request.setAttribute("telephone", telephone);
				request.setAttribute("adresse", adresse);
				RequestDispatcher rd = request.getRequestDispatcher("/affichageProfil.jsp");
				rd.forward(request, response);
				
			}


	}


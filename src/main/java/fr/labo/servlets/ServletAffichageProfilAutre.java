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


		public class ServletAffichageProfilAutre extends HttpServlet {
			private static final long serialVersionUID = 1L;
		       
		    public ServletAffichageProfilAutre() {
		        super();
		    }

		    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        try {
		            
		        	
		            UtilisateurManager um = new UtilisateurManager();
		            String user = request.getParameter("pseudo");
		            Utilisateur us = um.getUserByPseudo(user);
		            
		            System.out.println("user = " + user);

		            if (us != null) {
		                String pseudo = us.getPseudo();
		                String nom = us.getNom();
		                String prenom = us.getPrenom();
		                String email = us.getEmail();
		                String telephone = us.getTelephone();
		                Adresse adresse = us.getAdresse();

		                request.setAttribute("pseudo", pseudo);
		                request.setAttribute("nom", nom);
		                request.setAttribute("prenom", prenom);
		                request.setAttribute("email", email);
		                request.setAttribute("telephone", telephone);
		                request.setAttribute("adresse", adresse);

		                RequestDispatcher rd = request.getRequestDispatcher("/affichageProfilAutre.jsp");
		                rd.forward(request, response);
		            } else {
		                // Handle the case when user is not found
		                response.getWriter().append("User not found");
		            }
		        } catch (Exception e) {
		            // Handle exceptions appropriately
		            e.printStackTrace();
		            response.getWriter().append("Error occurred: " + e.getMessage());
		        } finally {
		            // Close resources if needed
		        }



	}
		    
		}


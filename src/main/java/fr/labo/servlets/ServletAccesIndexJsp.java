package fr.labo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ServletAccesIndexJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Servlet d'accés à la JSP Index. Point d'entrée de l'application
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//////A modifier avec la liste des categorie/////
		//////Utilisation de l'objet User pour le test///
		
//		User user1 = new User("nom-a","libelle-a");
//		User user2 = new User("nom-b","libelle-b");
//
//		List<User> categorieListe = new ArrayList<>();
//		categorieListe.add(user1);
//		categorieListe.add(user2);
//		
//		////////////////////////////////////////////////
//		
//		request.setAttribute("categorieListe", categorieListe);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
